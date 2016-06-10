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

    private static final String regexpForStringValues = "(.*)";
    private static final String regexpForIntegerValues = "(\\d*)";
    private static final String valueIdentificatorSeparator = FormatValuesSupplier.valueIdentificatorSeparator;
    private static final String twoDescriptionSeparator = FormatValuesSupplier.twoIdentificatorSeparator;

    public static EntityTrack parseEntityTrack(String currentString) throws RuntimeException {
        EntityTrack resultEntityTrack = new EntityTrack();

        String trackNameIdentificator = FormatValuesSupplier.trackNameIdentificator;

        String regexpForTrackName = trackNameIdentificator + valueIdentificatorSeparator + regexpForStringValues;

        String trackLengthIdentificator = FormatValuesSupplier.trackLengthIdentificator;
        String regexpForTrackLength = trackLengthIdentificator + valueIdentificatorSeparator + regexpForIntegerValues;

        String regexpForTrackDescription = regexpForTrackName + twoDescriptionSeparator + regexpForTrackLength;

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

        String albumNameIdentificator = FormatValuesSupplier.albumNameIdentificator;

        String regexpForAlbumName = albumNameIdentificator + valueIdentificatorSeparator + regexpForStringValues;

        String albumGenreIdentificator = FormatValuesSupplier.albumGenreIdentificator;

        String regexpForGenreName = albumGenreIdentificator + valueIdentificatorSeparator + regexpForStringValues;

        String regexpForAlbumDescription = regexpForAlbumName + twoDescriptionSeparator + regexpForGenreName;

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

        String artistNameIdentificator = FormatValuesSupplier.artistNameIdentificator;

        String regexpForArtistName = artistNameIdentificator + valueIdentificatorSeparator + regexpForStringValues;

        String regexpForArtistDescription = regexpForArtistName;

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

        String catalogueNameIdentificator = FormatValuesSupplier.catalogueNameIdentificator;

        String regexpForCatalogueName = catalogueNameIdentificator + valueIdentificatorSeparator + regexpForStringValues;

        String regexpForCatalogueDescription = regexpForCatalogueName;

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
