package entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alexandermiheev on 06.06.16.
 */
public class EntityAlbum implements Serializable {
    private String entityAlbumName;
    private String entityAlbumGenre;
    private List<EntityTrack> entityAlbumEntityTracks;

    public EntityAlbum(String entityAlbumName, String entityAlbumGenre, List<EntityTrack> entityAlbumEntityTracks) {
        this.entityAlbumName = entityAlbumName;
        this.entityAlbumGenre = entityAlbumGenre;
        this.entityAlbumEntityTracks = entityAlbumEntityTracks;
    }

    public EntityAlbum() {
        this.entityAlbumName = "Various Album";
        this.entityAlbumGenre = "Various Genre";
    }

    public String getEntityAlbumName() {
        return entityAlbumName;
    }

    public void setEntityAlbumName(String entityAlbumName) {
        this.entityAlbumName = entityAlbumName;
    }

    public List<EntityTrack> getEntityAlbumEntityTracks() {
        return entityAlbumEntityTracks;
    }

    public void setEntityAlbumEntityTracks(List<EntityTrack> entityAlbumEntityTracks) {
        this.entityAlbumEntityTracks = entityAlbumEntityTracks;
    }

    public String getEntityAlbumGenre() {
        return entityAlbumGenre;
    }

    public void setEntityAlbumGenre(String entityAlbumGenre) {
        this.entityAlbumGenre = entityAlbumGenre;
    }
}
