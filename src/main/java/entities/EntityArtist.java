package entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alexandermiheev on 06.06.16.
 */
public class EntityArtist implements Serializable {
    private String entityArtistName;
    private List<EntityAlbum> entityAlbumList;

    public EntityArtist(String entityArtistName, List<EntityAlbum> entityAlbumList) {
        this.entityArtistName = entityArtistName;
        this.entityAlbumList = entityAlbumList;
    }

    public EntityArtist() {
        this.entityArtistName = "Various Artist";
    }

    public String getEntityArtistName() {
        return entityArtistName;
    }

    public void setEntityArtistName(String entityArtistName) {
        this.entityArtistName = entityArtistName;
    }

    public List<EntityAlbum> getEntityAlbumList() {
        return entityAlbumList;
    }

    public void setEntityAlbumList(List<EntityAlbum> entityAlbumList) {
        this.entityAlbumList = entityAlbumList;
    }
}
