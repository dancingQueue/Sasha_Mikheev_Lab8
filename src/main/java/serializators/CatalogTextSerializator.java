package serializators;

import converters.CatalogueConverter;
import entities.EntityAlbum;
import entities.EntityArtist;
import entities.EntityCatalogue;
import entities.EntityTrack;
import interfaces.Serializator;
import model.Catalogue;
import parsers.StringParser;
import suppliers.FormatValuesSupplier;

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

    private static final String FILE_FORMAT = ".txt";

    private static final String TRACK_IDENTIFICATOR = FormatValuesSupplier.TRACK_IDENTIFICATOR;
    private static final String ARTIST_IDENTIFICATOR = FormatValuesSupplier.ARTIST_IDENTIFICATOR;
    private static final String ALBUM_IDENTIFICATOR = FormatValuesSupplier.ALBUM_IDENTIFICATOR;
    private static final String CATALOGUE_IDENTIFICATOR = FormatValuesSupplier.CATALOGUE_IDENTIFICATOR;

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
        String outputFileName = entityCatalogue.getEntityCatalogueName() + FILE_FORMAT;
        try (PrintStream outStream = new PrintStream(outputFileName)){

            WriteInStream.writeCatalogue(entityCatalogue, outStream);

        } catch (IOException e) {
            throw new RuntimeException("serialize() IOException: " + e.getMessage());
        }
    }


    private void processIdentificator(String currentIdentificator) throws RuntimeException {
        if (TRACK_IDENTIFICATOR.equals(currentIdentificator)) {
            processTrack();
        } else if (ARTIST_IDENTIFICATOR.equals(currentIdentificator)) {
            processArtist();
        } else if (ALBUM_IDENTIFICATOR.equals(currentIdentificator)) {
            processAlbum();
        } else if (CATALOGUE_IDENTIFICATOR.equals(currentIdentificator)) {
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
            throw new RuntimeException("processTrack() IOException: " + e.getMessage());
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
            throw new RuntimeException("processAlbum() IOException: " + e.getMessage());
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
            throw new RuntimeException("processArtist() IOException: " + e.getMessage());
        }
    }

    private void processCatalogue() throws RuntimeException {
        try {
            String currentCatalogueDescription = inputStream.readLine();

            resultEntityCatalogue = StringParser.parseEntityCatalogue(currentCatalogueDescription);
            entityArtistList = new ArrayList<>();

        } catch (IOException e) {
            throw new RuntimeException("processCatalogue() IOException: " + e.getMessage());
        }
    }


    public Catalogue deserialize(String catalogueName) {
        resultEntityCatalogue = new EntityCatalogue();
        String inputFileName = catalogueName + FILE_FORMAT;
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
            throw new RuntimeException("deserialize() IOException: " + e.getMessage());
        }
        Catalogue resultCatalogue = CatalogueConverter.convertToCatalogue(resultEntityCatalogue);
        return resultCatalogue;
    }
}
