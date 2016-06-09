package suppliers;

import model.Album;
import model.Artist;
import model.Catalogue;
import model.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by alexandermiheev on 09.06.16.
 */
public class Supplier {
    private static String[] albumNames = {"Views", "Black", "Lemonade", "Skin", "Blurryface", "Algebra"};
    private static String[] trackNames = {"Save the World!", "Prime", "Fibonacci", "Cube", "Love", "Hate"};
    private static String[] genreNames = {"Rock", "Hip-hop", "Mathcore", "Pop", "Techno", "Opera", "Ethnic"};
    private static String[] artistNames = {"Benjamin Franklin", "John Gold", "Chris Rock", "Matthew Long", "Vanessa Bright"};
    private static String[] catalogueNames = {"Music Library", "Encyclopedia", "wiki-music"};
    private static Random random = new Random();

    public static String getAlbumName() {
        int amountOfAlbumNames = albumNames.length;
        int index = random.nextInt(amountOfAlbumNames);
        return albumNames[index];
    }

    public static String getTrackName() {
        int amountOfTrackNames = trackNames.length;
        int index = random.nextInt(amountOfTrackNames);
        return trackNames[index];
    }

    public static String getGenreName() {
        int amountOfGenreNames = genreNames.length;
        int index = random.nextInt(amountOfGenreNames);
        return genreNames[index];
    }

    public static String getArtistName() {
        int amountOfArtistNames = artistNames.length;
        int index = random.nextInt(amountOfArtistNames);
        return artistNames[index];
    }

    public static String getCatalogueName() {
        int amountOfCatalogueNames = catalogueNames.length;
        int index = random.nextInt(amountOfCatalogueNames);
        return catalogueNames[index];
    }

    public static Integer getTrackLength() {
        return random.nextInt(600);
    }

    public static Track getTrack() {
        String trackName = getTrackName();
        Integer trackLength = getTrackLength();
        return new Track(trackName, trackLength);
    }

    public static Album getAlbum(int amountOfTracks) {
        String albumName = getAlbumName();
        String albumGenre = getGenreName();
        List<Track> trackList = new ArrayList<>();

        for (int i = 0; i < amountOfTracks; i++) {
            Track currentTrack = getTrack();
            trackList.add(currentTrack);
        }
        return new Album(albumName, albumGenre, trackList);
    }

    public static Artist getArtist(int amountOfAlbums) {
        String artistName = getArtistName();
        List<Album> albumList = new ArrayList<>();

        for (int i = 0; i < amountOfAlbums; i++) {
            Album currentAlbum = getAlbum(3);
            albumList.add(currentAlbum);
        }

        return new Artist(artistName, albumList);

    }

    public static Catalogue getCatalogue(int amountOfArtists) {
        String catalogueName = getCatalogueName();
        List<Artist> artistList = new ArrayList<>();

        for (int i = 0; i < amountOfArtists; i++) {
            Artist currentArtist = getArtist(2);
            artistList.add(currentArtist);
        }

        return new Catalogue(catalogueName, artistList);

    }

}
