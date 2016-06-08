package model;

/**
 * Created by alexandermiheev on 08.06.16.
 */
public class Track {
    private String trackName;
    private Integer trackLengthInSeconds;

    public Track(String trackName, Integer trackLengthInSeconds) {
        this.trackName = trackName;
        this.trackLengthInSeconds = trackLengthInSeconds;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Integer getTrackLengthInSeconds() {
        return trackLengthInSeconds;
    }

    public void setTrackLengthInSeconds(Integer trackLengthInSeconds) {
        this.trackLengthInSeconds = trackLengthInSeconds;
    }
}
