package suppliers;

/**
 * Created by alexandermiheev on 09.06.16.
 */
public class FormatValuesSupplier {
    private static String trackIdentificator = "Track";
    private static String trackNameIdentificator = "Name:";
    private static String trackLengthIdentificator = "Duration in seconds:";

    private static String albumIdentificator = "Album";
    private static String albumNameIdentificator = "Name:";
    private static String albumGenreIdentificator = "Genre:";

    private static String artistIdentificator = "Artist";
    private static String artistNameIdentificator = "Name:";

    private static String catalogueIdentificator = "Catalogue";
    private static String catalogueNameIdentificator = "Name:";

    private static String twoIdentificatorSeparator = "; ";
    private static String valueIdentificatorSeparator = " ";

    public static String getValueIdentificatorSeparator() {
        return valueIdentificatorSeparator;
    }

    public static void setValueIdentificatorSeparator(String valueIdentificatorSeparator) {
        FormatValuesSupplier.valueIdentificatorSeparator = valueIdentificatorSeparator;
    }


    public static String getTrackIdentificator() {
        return trackIdentificator;
    }

    public static void setTrackIdentificator(String trackIdentificator) {
        FormatValuesSupplier.trackIdentificator = trackIdentificator;
    }

    public static String getTwoIdentificatorSeparator() {
        return twoIdentificatorSeparator;
    }

    public static void setTwoIdentificatorSeparator(String twoIdentificatorSeparator) {
        FormatValuesSupplier.twoIdentificatorSeparator = twoIdentificatorSeparator;
    }

    public static String getCatalogueNameIdentificator() {
        return catalogueNameIdentificator;
    }

    public static void setCatalogueNameIdentificator(String catalogueNameIdentificator) {
        FormatValuesSupplier.catalogueNameIdentificator = catalogueNameIdentificator;
    }

    public static String getCatalogueIdentificator() {
        return catalogueIdentificator;
    }

    public static void setCatalogueIdentificator(String catalogueIdentificator) {
        FormatValuesSupplier.catalogueIdentificator = catalogueIdentificator;
    }

    public static String getArtistNameIdentificator() {
        return artistNameIdentificator;
    }

    public static void setArtistNameIdentificator(String artistNameIdentificator) {
        FormatValuesSupplier.artistNameIdentificator = artistNameIdentificator;
    }

    public static String getAlbumGenreIdentificator() {
        return albumGenreIdentificator;
    }

    public static void setAlbumGenreIdentificator(String albumGenreIdentificator) {
        FormatValuesSupplier.albumGenreIdentificator = albumGenreIdentificator;
    }

    public static String getAlbumNameIdentificator() {
        return albumNameIdentificator;
    }

    public static void setAlbumNameIdentificator(String albumNameIdentificator) {
        FormatValuesSupplier.albumNameIdentificator = albumNameIdentificator;
    }

    public static String getAlbumIdentificator() {
        return albumIdentificator;
    }

    public static void setAlbumIdentificator(String albumIdentificator) {
        FormatValuesSupplier.albumIdentificator = albumIdentificator;
    }

    public static String getTrackLengthIdentificator() {
        return trackLengthIdentificator;
    }

    public static void setTrackLengthIdentificator(String trackLengthIdentificator) {
        FormatValuesSupplier.trackLengthIdentificator = trackLengthIdentificator;
    }

    public static String getTrackNameIdentificator() {
        return trackNameIdentificator;
    }

    public static void setTrackNameIdentificator(String trackNameIdentificator) {
        FormatValuesSupplier.trackNameIdentificator = trackNameIdentificator;
    }

    public static String getArtistIdentificator() {
        return artistIdentificator;
    }

    public static void setArtistIdentificator(String artistIdentificator) {
        FormatValuesSupplier.artistIdentificator = artistIdentificator;
    }
}
