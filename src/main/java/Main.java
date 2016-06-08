import entities.EntityAlbum;
import entities.EntityTrack;
import model.Album;
import model.Artist;
import model.Track;
import serializators.AlbumSerializator;
import serializators.ArtistSerializator;
import serializators.TrackSerializator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alexandermiheev on 06.06.16.
 */
public class Main {
    public static void main(String[] args) {
        new Run().run();
    }
}
