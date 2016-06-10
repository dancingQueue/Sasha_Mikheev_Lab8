package parsers;

import entities.EntityAlbum;
import entities.EntityArtist;
import entities.EntityCatalogue;
import entities.EntityTrack;
import suppliers.FormatValuesSupplier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alexandermiheev on 08.06.16.
 */
public class StringParser {

    private static final String REGEXP_FOR_STRING_VALUES = "(.*)";
    private static final String REGEXP_FOR_INTEGER_VALUES = "(\\d*)";
    private static final String VALUE_IDENTIFICATOR_SEPARATOR = FormatValuesSupplier.VALUE_IDENTIFICATOR_SEPARATOR;
    private static final String TWO_IDENTIFICATOR_SEPARATOR = FormatValuesSupplier.TWO_IDENTIFICATOR_SEPARATOR;

    public static EntityTrack parseEntityTrack(String currentString) throws RuntimeException {
        EntityTrack resultEntityTrack = new EntityTrack();

        String trackNameIdentificator = FormatValuesSupplier.TRACK_NAME_IDENTIFICATOR;

        String regexpForTrackName = trackNameIdentificator + VALUE_IDENTIFICATOR_SEPARATOR + REGEXP_FOR_STRING_VALUES;

        String trackLengthIdentificator = FormatValuesSupplier.TRACK_LENGTH_IDENTIFICATOR;
        String regexpForTrackLength = trackLengthIdentificator + VALUE_IDENTIFICATOR_SEPARATOR + REGEXP_FOR_INTEGER_VALUES;

        String regexpForTrackDescription = regexpForTrackName + TWO_IDENTIFICATOR_SEPARATOR + regexpForTrackLength;

        Pattern trackPattern = Pattern.compile(regexpForTrackDescription);
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

        String albumNameIdentificator = FormatValuesSupplier.ALBUM_NAME_IDENTIFICATOR;

        String regexpForAlbumName = albumNameIdentificator + VALUE_IDENTIFICATOR_SEPARATOR + REGEXP_FOR_STRING_VALUES;

        String albumGenreIdentificator = FormatValuesSupplier.ALBUM_GENRE_IDENTIFICATOR;

        String regexpForGenreName = albumGenreIdentificator + VALUE_IDENTIFICATOR_SEPARATOR + REGEXP_FOR_STRING_VALUES;

        String regexpForAlbumDescription = regexpForAlbumName + TWO_IDENTIFICATOR_SEPARATOR + regexpForGenreName;

        Pattern albumPattern = Pattern.compile(regexpForAlbumDescription);
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

        String artistNameIdentificator = FormatValuesSupplier.ARTIST_NAME_IDENTIFICATOR;

        String regexpForArtistDescription = artistNameIdentificator
                + VALUE_IDENTIFICATOR_SEPARATOR + REGEXP_FOR_STRING_VALUES;


        Pattern artistPattern = Pattern.compile(regexpForArtistDescription);
        Matcher artistMatcher = artistPattern.matcher(currentString);

        if (artistMatcher.find()) {
            String resultArtistName = artistMatcher.group(1);
            resultEntityArtist.setEntityArtistName(resultArtistName);
        } else {
            throw new RuntimeException("Current string '" + currentString + "' is not a valid artist description");
        }

        return resultEntityArtist;
    }

    public static EntityCatalogue parseEntityCatalogue(String currentString) throws RuntimeException {
        EntityCatalogue resultEntityCatalogue = new EntityCatalogue();

        String catalogueNameIdentificator = FormatValuesSupplier.CATALOGUE_NAME_IDENTIFICATOR;

        String regexpForCatalogueDescription = catalogueNameIdentificator
                + VALUE_IDENTIFICATOR_SEPARATOR + REGEXP_FOR_STRING_VALUES;

        Pattern cataloguePattern = Pattern.compile(regexpForCatalogueDescription);
        Matcher catalogueMatcher = cataloguePattern.matcher(currentString);

        if (catalogueMatcher.find()) {
            String resultCatalogueName = catalogueMatcher.group(1);
            resultEntityCatalogue.setEntityCatalogueName(resultCatalogueName);
        } else {
            throw new RuntimeException("Current string '" + currentString + "' is not a valid catalogue description");
        }

        return resultEntityCatalogue;
    }

}
