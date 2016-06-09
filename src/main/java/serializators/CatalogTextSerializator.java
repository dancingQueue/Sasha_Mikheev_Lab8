package serializators;

import converters.CatalogueConverter;
import entities.EntityAlbum;
import entities.EntityArtist;
import entities.EntityCatalogue;
import entities.EntityTrack;
import interfaces.Serializator;
import model.Catalogue;
import parsers.StringParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 09.06.16.
 */
public class CatalogTextSerializator implements Serializator<Catalogue> {

    private List<EntityAlbum> entityAlbumList;
    private List<EntityTrack> entityTrackList;
    private List<EntityArtist> entityArtistList;

    private EntityAlbum currentEntityAlbum;
    private String currentAlbumDescription;
    private String currentArtistDescription;
    private BufferedReader inputStream;
    private EntityArtist currentEntityArtist;
    private EntityCatalogue resultEntityCatalogue;

    public void serialize(Catalogue catalogue) throws RuntimeException {
        EntityCatalogue entityCatalogue = CatalogueConverter.convertToEntityCatalogue(catalogue);
        try (PrintStream outStream = new PrintStream(entityCatalogue.getEntityCatalogueName() + ".txt");){
            WriteInStream.writeCatalogue(entityCatalogue, outStream);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    private void processIdentificator(String currentIdentificator) throws RuntimeException {
        if ("Track".equals(currentIdentificator)) {
            processTrack();
        } else if ("Artist".equals(currentIdentificator)) {
            processArtist();
        } else if ("Album".equals(currentIdentificator)) {
            processAlbum();
        } else if ("Catalogue".equals(currentIdentificator)) {
            processCatalogue();
        } else {
            throw new RuntimeException("No such identificator: " + currentIdentificator);
        }
    }

    private void processTrack() throws RuntimeException {
        try {
            EntityTrack entityTrack = StringParser.parseEntityTrack(inputStream.readLine());
            if (entityTrackList == null) {
                throw new RuntimeException("We have no album yet to add the track!");
            }
            entityTrackList.add(entityTrack);

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void fillAlbum() throws RuntimeException {
        if (entityTrackList != null && entityTrackList.size() > 0) {
            currentEntityAlbum.setEntityAlbumEntityTracks(entityTrackList);
            entityAlbumList.add(currentEntityAlbum);
        } else if (entityTrackList != null && entityTrackList.size() == 0) {
            throw new RuntimeException("Zero tracks is not enough for making an album");
        }
    }

    private void processAlbum() throws RuntimeException {
        try {
            fillAlbum();
            entityTrackList = new ArrayList<>();
            currentAlbumDescription = inputStream.readLine();
            currentEntityAlbum = StringParser.parseEntityAlbum(currentAlbumDescription);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void fillArtist() throws RuntimeException {
        if (entityAlbumList != null && entityAlbumList.size() > 0) {
            currentEntityArtist.setEntityAlbumList(entityAlbumList);
            entityArtistList.add(currentEntityArtist);
        } else if (entityAlbumList != null && entityAlbumList.size() == 0) {
            throw new RuntimeException("Zero albums is not enough for becoming an artist");
        }
    }

    private void processArtist() throws RuntimeException {
        try {
            fillAlbum();
            fillArtist();
            currentArtistDescription = inputStream.readLine();
            currentEntityArtist = StringParser.parseEntityArtist(currentArtistDescription);
            entityAlbumList = new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void processCatalogue() throws RuntimeException {
        try {
            String currentCatalogueDescription = inputStream.readLine();
            resultEntityCatalogue = StringParser.parseEntityCatalogue(currentCatalogueDescription);
            entityArtistList = new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public Catalogue deserialize(String catalogueName) {
        resultEntityCatalogue = new EntityCatalogue();
        String inputFileName = catalogueName + ".txt";
        try (BufferedReader currentInputStream = new BufferedReader(new FileReader(inputFileName))) {
            inputStream = currentInputStream;

            while (inputStream.ready()) {
                String currentIdentificator = inputStream.readLine();
                processIdentificator(currentIdentificator);
            }

            fillAlbum();
            fillArtist();

            resultEntityCatalogue.setEntityArtistList(entityArtistList);

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return CatalogueConverter.convertToCatalogue(resultEntityCatalogue);
    }
}
