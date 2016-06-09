package serializators;

import entities.EntityAlbum;
import entities.EntityArtist;
import entities.EntityCatalogue;
import entities.EntityTrack;

import java.io.PrintStream;

/**
 * Created by alexandermiheev on 08.06.16.
 */
class WriteInStream {
    public static void writeTrack(EntityTrack entityTrack, PrintStream outStream) {
        outStream.println("Track");
        outStream.println("Name: " + entityTrack.getEntityTrackName() + "; Duration: "
                + entityTrack.getEntityTrackLengthInSeconds() + " seconds.");
    }
    public static void writeAlbum(EntityAlbum entityAlbum, PrintStream outStream) {
        outStream.println("Album");
        outStream.println("Name: " + entityAlbum.getEntityAlbumName() + "; Genre: "
                + entityAlbum.getEntityAlbumGenre() + ".");
        for (EntityTrack entityTrack : entityAlbum.getEntityAlbumEntityTracks()) {
            writeTrack(entityTrack, outStream);
        }
    }
    public static void writeArtist(EntityArtist entityArtist, PrintStream outStream) {
        outStream.println("Artist");
        outStream.println("Name: " + entityArtist.getEntityArtistName() + ".");

        for (EntityAlbum entityAlbum : entityArtist.getEntityAlbumList()) {
            writeAlbum(entityAlbum, outStream);
        }
    }
    public static void writeCatalogue(EntityCatalogue entityCatalogue, PrintStream outStream) {
        outStream.println("Catalogue");
        outStream.println("Name: " + entityCatalogue.getEntityCatalogueName() + ".");

        for (EntityArtist entityArtist: entityCatalogue.getEntityArtistList()) {
            writeArtist(entityArtist, outStream);
        }
    }
}
