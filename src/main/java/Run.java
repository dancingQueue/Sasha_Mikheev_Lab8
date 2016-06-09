import model.Album;
import model.Artist;
import model.Track;
import serializators.AlbumSerializator;
import serializators.ArtistSerializator;
import serializators.TrackSerializator;
import suppliers.Supplier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 09.06.16.
 */
public class Run {

    public void printTrack(Track track) {
        System.out.println("Track name: " + track.getTrackName() + "; Duration: "
                + track.getTrackLengthInSeconds() + " seconds.");
    }

    public void printAlbum(Album album) {
        System.out.println("Album name: " + album.getAlbumName() + "; Genre: " + album.getAlbumGenre() + ".");
        for (Track track: album.getAlbumTracks()) {
            printTrack(track);
        }
    }
    public void printArtist(Artist artist) {
        System.out.println("Artist name: " + artist.getArtistName() + ".");
        for (Album album: artist.getAlbumList()) {
            printAlbum(album);
        }
    }

    public void testTrackSerializator() {
        System.out.println("Test track serialization");

        Track track = Supplier.getTrack();
        String trackName = track.getTrackName();

        System.out.println("Serialized track");
        printTrack(track);

        TrackSerializator trackSerializator = new TrackSerializator();
        trackSerializator.serialization(track);

        Track deserializedTrack = trackSerializator.deserialization(trackName + ".txt");

        System.out.println("Deserialized track");
        printTrack(deserializedTrack);
    }

    public void testAlbumSerializator() {
        System.out.println("Test album serialization");

        Album album = Supplier.getAlbum(3);
        String albumName = album.getAlbumName();

        System.out.println("Serialized album");
        printAlbum(album);

        AlbumSerializator albumSerializator = new AlbumSerializator();

        albumSerializator.serialization(album);

        Album deserializedAlbum = albumSerializator.deserialization(albumName + ".txt");

        System.out.println("Deserialized album");
        printAlbum(deserializedAlbum);

    }

    public void testArtistSerializator() {
        System.out.println("Test artist serialization");
        Artist artist = Supplier.getArtist(2);
        String artistName = artist.getArtistName();

        System.out.println("Serialized artist");
        printArtist(artist);


        ArtistSerializator artistSerializator = new ArtistSerializator();

        artistSerializator.serialization(artist);

        Artist deserializedArtist = new ArtistSerializator().deserialization(artistName + ".txt");

        System.out.println("Deserialized artist");
        printArtist(deserializedArtist);
    }

    public void testAlbumWithZeroTracks() {
        System.out.println("Test album with zero tracks");
        Album album = new Album("Algebra", "Mathcore", new ArrayList<>());
        printAlbum(album);

        AlbumSerializator albumSerializator = new AlbumSerializator();

        albumSerializator.serialization(album);

        try {
            Album deserializedAlbum = albumSerializator.deserialization("Algebra.txt");
        } catch (RuntimeException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void testArtistWithZeroAlbums() {
        System.out.println("Test artist with zero albums");
        Artist artist = new Artist("Bavid Dowie", new ArrayList<>());
        printArtist(artist);
        ArtistSerializator artistSerializator = new ArtistSerializator();

        artistSerializator.serialization(artist);
        try {
            Artist deserializedArtist = new ArtistSerializator().deserialization("Bavid Dowie.txt");
        } catch (RuntimeException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void run() {
        testTrackSerializator();
        testAlbumSerializator();
        testArtistSerializator();
        testAlbumWithZeroTracks();
        testArtistWithZeroAlbums();
    }
}
