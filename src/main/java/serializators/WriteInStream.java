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

    private static String valueIdentificatorSeparator = FormatValuesSupplier.getValueIdentificatorSeparator();
    private static String twoDescriptionSeparator = FormatValuesSupplier.getTwoIdentificatorSeparator();

    public static void writeTrack(EntityTrack entityTrack, PrintStream outStream) {
        String trackIdentificator = FormatValuesSupplier.getTrackIdentificator();
        outStream.println(trackIdentificator);

        String nameIdentificator = FormatValuesSupplier.getTrackNameIdentificator();
        String nameDescription = nameIdentificator + valueIdentificatorSeparator
                + entityTrack.getEntityTrackName();

        String lengthIdentificator = FormatValuesSupplier.getTrackLengthIdentificator();
        String lengthDescription = lengthIdentificator + valueIdentificatorSeparator
                + entityTrack.getEntityTrackLengthInSeconds();

        String trackDescription = nameDescription + twoDescriptionSeparator
                + lengthDescription;
        outStream.println(trackDescription);
    }

    public static void writeAlbum(EntityAlbum entityAlbum, PrintStream outStream) {
        String albumIdentificator = FormatValuesSupplier.getAlbumIdentificator();
        outStream.println(albumIdentificator);

        String albumNameIdentificator = FormatValuesSupplier.getAlbumNameIdentificator();
        String albumNameDescription = albumNameIdentificator + valueIdentificatorSeparator
                + entityAlbum.getEntityAlbumName();

        String albumGenreIdentificator = FormatValuesSupplier.getAlbumGenreIdentificator();
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
        String artistIdentificator = FormatValuesSupplier.getArtistIdentificator();
        outStream.println(artistIdentificator);

        String artistNameIdentificator = FormatValuesSupplier.getArtistNameIdentificator();
        String artistNameDescription = artistNameIdentificator + valueIdentificatorSeparator
                + entityArtist.getEntityArtistName();

        String artistDescription = artistNameDescription;

        outStream.println(artistDescription);

        for (EntityAlbum entityAlbum : entityArtist.getEntityAlbumList()) {
            writeAlbum(entityAlbum, outStream);
        }
    }

    public static void writeCatalogue(EntityCatalogue entityCatalogue, PrintStream outStream) {
        String catalogueIdentificator = FormatValuesSupplier.getCatalogueIdentificator();
        outStream.println(catalogueIdentificator);

        String catalogueNameIdentificator = FormatValuesSupplier.getCatalogueNameIdentificator();
        String catalogueNameDescription = catalogueNameIdentificator
                + valueIdentificatorSeparator + entityCatalogue.getEntityCatalogueName();

        String catalogueDescription = catalogueNameDescription;
        outStream.println(catalogueDescription);

        for (EntityArtist entityArtist : entityCatalogue.getEntityArtistList()) {
            writeArtist(entityArtist, outStream);
        }
    }
}
