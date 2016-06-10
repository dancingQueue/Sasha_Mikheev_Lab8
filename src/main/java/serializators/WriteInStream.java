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

    private static String valueIdentificatorSeparator = FormatValuesSupplier.valueIdentificatorSeparator;
    private static String twoDescriptionSeparator = FormatValuesSupplier.twoIdentificatorSeparator;

    public static void writeTrack(EntityTrack entityTrack, PrintStream outStream) {
        String trackIdentificator = FormatValuesSupplier.trackIdentificator;
        outStream.println(trackIdentificator);

        String nameIdentificator = FormatValuesSupplier.trackNameIdentificator;
        String nameDescription = nameIdentificator + valueIdentificatorSeparator
                + entityTrack.getEntityTrackName();

        String lengthIdentificator = FormatValuesSupplier.trackLengthIdentificator;
        String lengthDescription = lengthIdentificator + valueIdentificatorSeparator
                + entityTrack.getEntityTrackLengthInSeconds();

        String trackDescription = nameDescription + twoDescriptionSeparator
                + lengthDescription;
        outStream.println(trackDescription);
    }

    public static void writeAlbum(EntityAlbum entityAlbum, PrintStream outStream) {
        String albumIdentificator = FormatValuesSupplier.albumIdentificator;
        outStream.println(albumIdentificator);

        String albumNameIdentificator = FormatValuesSupplier.albumNameIdentificator;
        String albumNameDescription = albumNameIdentificator + valueIdentificatorSeparator
                + entityAlbum.getEntityAlbumName();

        String albumGenreIdentificator = FormatValuesSupplier.albumGenreIdentificator;
        String albumGenreDescription = albumGenreIdentificator + valueIdentificatorSeparator
                + entityAlbum.getEntityAlbumGenre();

        String albumDescription = albumNameDescription + twoDescriptionSeparator
                + albumGenreDescription;
        outStream.println(albumDescription);

        for (EntityTrack entityTrack : entityAlbum.getEntityAlbumEntityTracks()) {
            writeTrack(entityTrack, outStream);
        }
    }

    public static void writeArtist(EntityArtist entityArtist, PrintStream outStream) {
        String artistIdentificator = FormatValuesSupplier.artistIdentificator;
        outStream.println(artistIdentificator);

        String artistNameIdentificator = FormatValuesSupplier.artistNameIdentificator;
        String artistDescription = artistNameIdentificator + valueIdentificatorSeparator
                + entityArtist.getEntityArtistName();

        outStream.println(artistDescription);

        for (EntityAlbum entityAlbum : entityArtist.getEntityAlbumList()) {
            writeAlbum(entityAlbum, outStream);
        }
    }

    public static void writeCatalogue(EntityCatalogue entityCatalogue, PrintStream outStream) {
        String catalogueIdentificator = FormatValuesSupplier.catalogueIdentificator;
        outStream.println(catalogueIdentificator);

        String catalogueNameIdentificator = FormatValuesSupplier.catalogueNameIdentificator;
        String catalogueDescription = catalogueNameIdentificator
                + valueIdentificatorSeparator + entityCatalogue.getEntityCatalogueName();

        outStream.println(catalogueDescription);

        for (EntityArtist entityArtist : entityCatalogue.getEntityArtistList()) {
            writeArtist(entityArtist, outStream);
        }
    }
}
