import interfaces.Serializator;
import model.Album;
import model.Artist;
import model.Catalogue;
import model.Track;
import serializators.CatalogByteSerializator;
import serializators.CatalogTextSerializator;
import suppliers.Supplier;


/**
 * Created by alexandermiheev on 09.06.16.
 */
public class Run {

    public void printTrack(Track track) {
        System.out.println("Track name: " + track.getTrackName() + "; Duration: "
                + track.getTrackLengthInSeconds() + " seconds.");
    }

    public void printAlbum(Album album) {
        System.out.println("Album name: " + album.getAlbumName() + "; Genre: " + album.getAlbumGenre() + ".");
        for (Track track: album.getAlbumTracks()) {
            printTrack(track);
        }
    }
    public void printArtist(Artist artist) {
        System.out.println("Artist name: " + artist.getArtistName() + ".");
        for (Album album: artist.getAlbumList()) {
            printAlbum(album);
        }
    }

    public void printCatalogue(Catalogue catalogue) {
        System.out.println("Catalogue name: " + catalogue.getCatalogueName() + ".");
        for (Artist artist: catalogue.getArtistList()) {
            printArtist(artist);
        }
    }

    public void testSerializator(Serializator<Catalogue> catalogueSerializator) {

        Catalogue catalogue = Supplier.getCatalogue(2);
        String catalogueName = catalogue.getCatalogueName();

        System.out.println("Serialized catalogue");
        printCatalogue(catalogue);

        catalogueSerializator.serialize(catalogue);

        Catalogue deserializedCatalogue = catalogueSerializator.deserialize(catalogueName);

        System.out.println("Deserialized catalogue");
        printCatalogue(deserializedCatalogue);
    }

    public void testCatalogueByteSerialization() {
        System.out.println("Test catalogue byte serializator");
        testSerializator(new CatalogByteSerializator());
    }

    public void testCatalogueTextSerialization() {
        System.out.println("Test catalogue text serializator");
        testSerializator(new CatalogTextSerializator());
    }

    public void run() {
        testCatalogueByteSerialization();
        testCatalogueTextSerialization();
    }
}
