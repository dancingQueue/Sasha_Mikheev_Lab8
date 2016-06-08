package converters;

import entities.EntityTrack;
import model.Track;

/**
 * Created by alexandermiheev on 08.06.16.
 */
public class TrackConverter {
    public static EntityTrack convertToEntityTrack(Track track) {
        String trackName = track.getTrackName();
        Integer trackLengthInSeconds = track.getTrackLengthInSeconds();
        return new EntityTrack(trackName, trackLengthInSeconds);
    }

    public static Track convertToTrack(EntityTrack entityTrack) {
        String entityTrackName = entityTrack.getEntityTrackName();
        Integer entityTrackLengthInSeconds = entityTrack.getEntityTrackLengthInSeconds();
        return new Track(entityTrackName, entityTrackLengthInSeconds);
    }
}
