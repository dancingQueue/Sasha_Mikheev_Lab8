package entities;

import java.io.Serializable;

/**
 * Created by alexandermiheev on 06.06.16.
 */
public class EntityTrack implements Serializable {
    private String entityTrackName;
    private Integer entityTrackLengthInSeconds;

    public EntityTrack(String entityTrackName, Integer entityTrackLengthInSeconds) {
        this.entityTrackName = entityTrackName;
        this.entityTrackLengthInSeconds = entityTrackLengthInSeconds;
    }

    public EntityTrack() {
        this.entityTrackName = "Various Track";
    }

    public String getEntityTrackName() {
        return entityTrackName;
    }

    public void setEntityTrackName(String entityTrackName) {
        this.entityTrackName = entityTrackName;
    }

    public Integer getEntityTrackLengthInSeconds() {
        return entityTrackLengthInSeconds;
    }

    public void setEntityTrackLengthInSeconds(Integer entityTrackLengthInSeconds) {
        this.entityTrackLengthInSeconds = entityTrackLengthInSeconds;
    }
}
