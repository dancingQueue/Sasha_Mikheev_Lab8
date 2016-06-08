package serializators;

import converters.ArtistConverter;
import entities.EntityAlbum;
import entities.EntityArtist;
import entities.EntityTrack;
import interfaces.Serializator;
import model.Artist;
import parsers.StringParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 08.06.16.
 */
public class ArtistSerializator implements Serializator<Artist> {

    private List<EntityAlbum> entityAlbumList;
    private List<EntityTrack> entityTrackList;

    private EntityAlbum currentEntityAlbum;
    private String currentAlbumDescription;
    private String currentArtistDescription;
    private BufferedReader inputStream;
    private EntityArtist entityArtist;

    public ArtistSerializator() {
        entityAlbumList = null;
        entityTrackList = null;
        currentEntityAlbum = null;
        currentAlbumDescription = null;
        currentArtistDescription = null;
    }

    public void serialization(Artist artist) {
        try {
            EntityArtist entityArtist = ArtistConverter.convertToEntityArtist(artist);
            PrintStream outStream = new PrintStream(entityArtist.getEntityArtistName() + ".txt");
            WriteInStream.writeArtist(entityArtist, outStream);
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processIdentificator(String currentIdentificator) {
        if (currentIdentificator.equals("Track")) {
            processTrack();
        } else if (currentIdentificator.equals("Artist")) {
            processArtist();
        } else if (currentIdentificator.equals("Album")) {
            processAlbum();
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
            e.printStackTrace();
        }
    }

    private void processAlbum() throws RuntimeException {
        try {
            if (entityTrackList != null && entityTrackList.size() > 0) {
                currentEntityAlbum.setEntityAlbumEntityTracks(entityTrackList);
                entityAlbumList.add(currentEntityAlbum);
            } else if (entityTrackList != null && entityTrackList.size() == 0) {
                throw new RuntimeException("Zero tracks is not enough for making an album");
            }
            entityTrackList = new ArrayList<>();
            currentAlbumDescription = inputStream.readLine();
            currentEntityAlbum = StringParser.parseEntityAlbum(currentAlbumDescription);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processArtist() throws RuntimeException {
        try {
            currentArtistDescription = inputStream.readLine();
            entityArtist = StringParser.parseEntityArtist(currentArtistDescription);
            entityAlbumList = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Artist deserialization(String fileName) throws RuntimeException {
        entityArtist = new EntityArtist();
        try {
            FileReader fileReader = new FileReader(fileName);
            inputStream = new BufferedReader(fileReader);

            while (inputStream.ready()) {
                String currentIdentificator = inputStream.readLine();
                processIdentificator(currentIdentificator);
            }

            if (entityTrackList != null) {
                currentEntityAlbum.setEntityAlbumEntityTracks(entityTrackList);
                entityAlbumList.add(currentEntityAlbum);
            }

            if (entityAlbumList.size() == 0) {
                throw new RuntimeException("Zero albums in not enough for becoming an artist");
            }

            entityArtist.setEntityAlbumList(entityAlbumList);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ArtistConverter.convertToArtist(entityArtist);
    }
}
