package converters;

import entities.EntityAlbum;
import entities.EntityTrack;
import model.Album;
import model.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 08.06.16.
 */
public class AlbumConverter {
    public static EntityAlbum convertToEntityAlbum(Album album) {
        String albumName = album.getAlbumName();
        String albumGenre = album.getAlbumGenre();
        List<Track> albumTrackList = album.getAlbumTracks();
        List<EntityTrack> entityTrackList = new ArrayList<>();

        for (Track track : albumTrackList) {
            EntityTrack convertedEntityTrack = TrackConverter.convertToEntityTrack(track);
            entityTrackList.add(convertedEntityTrack);
        }

        return new EntityAlbum(albumName, albumGenre, entityTrackList);
    }

    public static Album convertToAlbum(EntityAlbum entityAlbum) {
        String entityAlbumName = entityAlbum.getEntityAlbumName();
        String entityAlbumGenre = entityAlbum.getEntityAlbumGenre();
        List<EntityTrack> entityAlbumEntityTracks = entityAlbum.getEntityAlbumEntityTracks();
        List<Track> albumTrackList = new ArrayList<>();

        for (EntityTrack entityTrack : entityAlbumEntityTracks) {
            Track convertedTrack = TrackConverter.convertToTrack(entityTrack);
            albumTrackList.add(convertedTrack);
        }

        return new Album(entityAlbumName, entityAlbumGenre, albumTrackList);
    }
}
