package serializators;

import converters.AlbumConverter;
import entities.EntityAlbum;
import entities.EntityTrack;
import interfaces.Serializator;
import model.Album;
import parsers.StringParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 07.06.16.
 */
public class AlbumSerializator implements Serializator<Album> {

    private List<EntityTrack> entityTrackList;

    private EntityAlbum entityAlbum;
    private String currentAlbumDescription;
    private String currentArtistDescription;
    private BufferedReader inputStream;

    public AlbumSerializator() {
        entityTrackList = null;
        entityAlbum = null;
        currentAlbumDescription = null;
        currentArtistDescription = null;
    }
    public void serialization(Album album) {
        try {
            EntityAlbum entityAlbum = AlbumConverter.convertToEntityAlbum(album);
            PrintStream outStream = new PrintStream(entityAlbum.getEntityAlbumName() + ".txt");
            WriteInStream.writeAlbum(entityAlbum, outStream);
            outStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processIdentificator(String currentIdentificator) {
        if (currentIdentificator.equals("Track")) {
            processTrack();
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
            entityTrackList = new ArrayList<>();
            currentAlbumDescription = inputStream.readLine();
            entityAlbum = StringParser.parseEntityAlbum(currentAlbumDescription);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Album deserialization(String fileName) throws RuntimeException {
        entityAlbum = new EntityAlbum();

        try {
            FileReader fileReader = new FileReader(fileName);
            inputStream = new BufferedReader(fileReader);

            while (inputStream.ready()) {
                String currentIdentificator = inputStream.readLine();
                processIdentificator(currentIdentificator);
            }
            if (entityTrackList.size() == 0) {
                throw new RuntimeException("Zero tracks is not enough for an album");
            }

            entityAlbum.setEntityAlbumEntityTracks(entityTrackList);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return AlbumConverter.convertToAlbum(entityAlbum);
    }

}
