package serializators;

import entities.EntityAlbum;
import entities.EntityArtist;
import entities.EntityCatalogue;
import entities.EntityTrack;
import suppliers.FormatValuesSupplier;

import java.io.PrintStream;

/**
 * Created by alexandermiheev on 08.06.16.
 */
class WriteInStream {

    private static final String VALUE_IDENTIFICATOR_SEPARATOR = FormatValuesSupplier.VALUE_IDENTIFICATOR_SEPARATOR;
    private static final String TWO_IDENTIFICATOR_SEPARATOR = FormatValuesSupplier.TWO_IDENTIFICATOR_SEPARATOR;

    public static void writeTrack(EntityTrack entityTrack, PrintStream outStream) {
        String trackIdentificator = FormatValuesSupplier.TRACK_IDENTIFICATOR;
        outStream.println(trackIdentificator);

        String nameIdentificator = FormatValuesSupplier.TRACK_NAME_IDENTIFICATOR;
        String nameDescription = nameIdentificator + VALUE_IDENTIFICATOR_SEPARATOR
                + entityTrack.getEntityTrackName();

        String lengthIdentificator = FormatValuesSupplier.TRACK_LENGTH_IDENTIFICATOR;
        String lengthDescription = lengthIdentificator + VALUE_IDENTIFICATOR_SEPARATOR
                + entityTrack.getEntityTrackLengthInSeconds();

        String trackDescription = nameDescription + TWO_IDENTIFICATOR_SEPARATOR
                + lengthDescription;
        outStream.println(trackDescription);
    }

    public static void writeAlbum(EntityAlbum entityAlbum, PrintStream outStream) {
        String albumIdentificator = FormatValuesSupplier.ALBUM_IDENTIFICATOR;
        outStream.println(albumIdentificator);

        String albumNameIdentificator = FormatValuesSupplier.ALBUM_NAME_IDENTIFICATOR;
        String albumNameDescription = albumNameIdentificator + VALUE_IDENTIFICATOR_SEPARATOR
                + entityAlbum.getEntityAlbumName();

        String albumGenreIdentificator = FormatValuesSupplier.ALBUM_GENRE_IDENTIFICATOR;
        String albumGenreDescription = albumGenreIdentificator + VALUE_IDENTIFICATOR_SEPARATOR
                + entityAlbum.getEntityAlbumGenre();

        String albumDescription = albumNameDescription + TWO_IDENTIFICATOR_SEPARATOR
                + albumGenreDescription;
        outStream.println(albumDescription);

        for (EntityTrack entityTrack : entityAlbum.getEntityAlbumEntityTracks()) {
            writeTrack(entityTrack, outStream);
        }
    }

    public static void writeArtist(EntityArtist entityArtist, PrintStream outStream) {
        String artistIdentificator = FormatValuesSupplier.ARTIST_IDENTIFICATOR;
        outStream.println(artistIdentificator);

        String artistNameIdentificator = FormatValuesSupplier.ARTIST_NAME_IDENTIFICATOR;
        String artistDescription = artistNameIdentificator + VALUE_IDENTIFICATOR_SEPARATOR
                + entityArtist.getEntityArtistName();

        outStream.println(artistDescription);

        for (EntityAlbum entityAlbum : entityArtist.getEntityAlbumList()) {
            writeAlbum(entityAlbum, outStream);
        }
    }

    public static void writeCatalogue(EntityCatalogue entityCatalogue, PrintStream outStream) {
        String catalogueIdentificator = FormatValuesSupplier.CATALOGUE_IDENTIFICATOR;
        outStream.println(catalogueIdentificator);

        String catalogueNameIdentificator = FormatValuesSupplier.CATALOGUE_NAME_IDENTIFICATOR;
        String catalogueDescription = catalogueNameIdentificator
                + VALUE_IDENTIFICATOR_SEPARATOR + entityCatalogue.getEntityCatalogueName();

        outStream.println(catalogueDescription);

        for (EntityArtist entityArtist : entityCatalogue.getEntityArtistList()) {
            writeArtist(entityArtist, outStream);
        }
    }
}
