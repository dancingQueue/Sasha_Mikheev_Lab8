package entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alexandermiheev on 09.06.16.
 */
public class EntityCatalogue implements Serializable {
    private String entityCatalogueName;
    private List<EntityArtist> entityArtistList;

    public EntityCatalogue(String entityCatalogueName, List<EntityArtist> entityArtistList) {
        this.entityCatalogueName = entityCatalogueName;
        this.entityArtistList = entityArtistList;
    }

    public EntityCatalogue() {
        this.entityCatalogueName = "Various Catalogue";
    }

    public String getEntityCatalogueName() {
        return entityCatalogueName;
    }

    public void setEntityCatalogueName(String entityCatalogueName) {
        this.entityCatalogueName = entityCatalogueName;
    }

    public List<EntityArtist> getEntityArtistList() {
        return entityArtistList;
    }

    public void setEntityArtistList(List<EntityArtist> entityArtistList) {
        this.entityArtistList = entityArtistList;
    }
}
