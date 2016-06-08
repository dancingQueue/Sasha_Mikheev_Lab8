package parsers;

import entities.EntityAlbum;
import entities.EntityArtist;
import entities.EntityTrack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alexandermiheev on 08.06.16.
 */
public class StringParser {

    public static EntityTrack parseEntityTrack(String currentString) throws RuntimeException {
        EntityTrack resultEntityTrack = new EntityTrack();

        Pattern trackPattern = Pattern.compile("Name: (..*?); Duration: (\\d*) seconds.");
        Matcher trackMatcher = trackPattern.matcher(currentString);

        if (trackMatcher.find()) {
            String resultTrackName = trackMatcher.group(1);
            resultEntityTrack.setEntityTrackName(resultTrackName);

            Integer resultTrackLength = new Integer(trackMatcher.group(2));
            resultEntityTrack.setEntityTrackLengthInSeconds(resultTrackLength);
        } else {
            throw new RuntimeException("Current string '" + currentString + "' is not a valid track description");
        }

        return resultEntityTrack;
    }

    public static EntityAlbum parseEntityAlbum(String currentString) throws RuntimeException {
        EntityAlbum resultEntityAlbum = new EntityAlbum();

        Pattern albumPattern = Pattern.compile("Name: (..*?); Genre: (..*?)[.]");
        Matcher albumMatcher = albumPattern.matcher(currentString);

        if (albumMatcher.find()) {
            String resultAlbumName = albumMatcher.group(1);
            resultEntityAlbum.setEntityAlbumName(resultAlbumName);

            String resultAlbumGenre = albumMatcher.group(2);
            resultEntityAlbum.setEntityAlbumGenre(resultAlbumGenre);
        } else {
            throw new RuntimeException("Current string '" + currentString + "' is not a valid album description");
        }

        return resultEntityAlbum;
    }

    public static EntityArtist parseEntityArtist(String currentString) throws RuntimeException {
        EntityArtist resultEntityArtist = new EntityArtist();

        Pattern artistPattern = Pattern.compile("Name: (..*?)[.]");
        Matcher artistMatcher = artistPattern.matcher(currentString);

        if (artistMatcher.find()) {
            String resultArtistName = artistMatcher.group(1);
            resultEntityArtist.setEntityArtistName(resultArtistName);
        } else {
            throw new RuntimeException("Current string '" + currentString + "' is not a valid artist description");
        }

        return resultEntityArtist;
    }
}
