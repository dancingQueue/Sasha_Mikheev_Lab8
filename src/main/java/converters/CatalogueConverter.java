package converters;

import entities.EntityArtist;
import entities.EntityCatalogue;
import model.Artist;
import model.Catalogue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 09.06.16.
 */
public class CatalogueConverter {
    public static EntityCatalogue convertToEntityCatalogue(Catalogue catalogue) {
        String catalogueName = catalogue.getCatalogueName();
        List<EntityArtist> entityArtistList = new ArrayList<>();

        for (Artist artist : catalogue.getArtistList()) {
            entityArtistList.add(ArtistConverter.convertToEntityArtist(artist));
        }

        return new EntityCatalogue(catalogueName, entityArtistList);
    }

    public static Catalogue convertToCatalogue(EntityCatalogue entityCatalogue) {
        String entityCatalogueName = entityCatalogue.getEntityCatalogueName();
        List<Artist> artistList = new ArrayList<>();

        for (EntityArtist entityArtist : entityCatalogue.getEntityArtistList()) {
            artistList.add(ArtistConverter.convertToArtist(entityArtist));
        }

        return new Catalogue(entityCatalogueName, artistList);
    }
}
