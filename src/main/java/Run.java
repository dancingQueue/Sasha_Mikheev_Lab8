import model.Album;
import model.Artist;
import model.Track;
import serializators.AlbumSerializator;
import serializators.ArtistSerializator;
import serializators.TrackSerializator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 09.06.16.
 */
public class Run {

    public void testTrackSerializator() {
        Track track = new Track("Save the World!", 365);

        TrackSerializator trackSerializator = new TrackSerializator();

        trackSerializator.serialization(track);

        Track deserializedTrack = trackSerializator.deserialization("Save the World!.txt");

        System.out.println(deserializedTrack.getTrackName());
        System.out.println(deserializedTrack.getTrackLengthInSeconds());
    }

    public void testAlbumSerializator() {

        List<Track> trackList = new ArrayList<>();

        trackList.add(new Track("Prime", 97));
        trackList.add(new Track("Fibonacci", 144));
        trackList.add(new Track("Cube", 125));
        Album album = new Album("Algebra", "Mathcore", trackList);

        AlbumSerializator albumSerializator = new AlbumSerializator();

        albumSerializator.serialization(album);

        Album deserializedAlbum = albumSerializator.deserialization("Algebra.txt");

        System.out.println(deserializedAlbum.getAlbumName());
        System.out.println(deserializedAlbum.getAlbumGenre());
        System.out.println(deserializedAlbum.getAlbumTracks().size());

    }

    public void testArtistSerializator() {
        List<Track> trackList = new ArrayList<>();

        trackList.add(new Track("Hate", 150));
        trackList.add(new Track("Love", 200));
        trackList.add(new Track("21 floor", 150));
        Album album = new Album("Lal", "Rock", trackList);

        List<Track> trackList2 = new ArrayList<>();

        trackList2.add(new Track("Repeat", 111));
        trackList2.add(new Track("Some Track With Long Name", 202));
        trackList2.add(new Track("22 floor", 33));
        Album album2 = new Album("Heroes", "Pop-Rock", trackList2);

        List<Album> albums = new ArrayList<>();
        albums.add(album);
        albums.add(album2);

        Artist artist = new Artist("Bavid Dowie", albums);

        ArtistSerializator artistSerializator = new ArtistSerializator();

        artistSerializator.serialization(artist);

        Artist deserializedArtist = new ArtistSerializator().deserialization("Bavid Dowie.txt");

    }

    public void test() {
        TrackSerializator trackSerializator = new TrackSerializator();
        Track deserializedTrack = trackSerializator.deserialization("Love.txt");

        System.out.println(deserializedTrack.getTrackName());
        System.out.println(deserializedTrack.getTrackLengthInSeconds());


    }

    public void testAlbumWithZeroTracks() {
        Album album = new Album("Algebra", "Mathcore", new ArrayList<>());

        AlbumSerializator albumSerializator = new AlbumSerializator();

        albumSerializator.serialization(album);

        try {
            Album deserializedAlbum = albumSerializator.deserialization("Algebra.txt");
        } catch (RuntimeException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void testArtistWithZeroAlbums() {
        Artist artist = new Artist("Bavid Dowie", new ArrayList<>());

        ArtistSerializator artistSerializator = new ArtistSerializator();

        artistSerializator.serialization(artist);
        try {
            Artist deserializedArtist = new ArtistSerializator().deserialization("Bavid Dowie.txt");
        } catch (RuntimeException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void run() {
     /*   testTrackSerializator();
        testAlbumSerializator();
        testArtistSerializator(); */
        //test();
        testAlbumWithZeroTracks();
        testArtistWithZeroAlbums();
    }
}
