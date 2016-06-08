package converters;

import entities.EntityAlbum;
import entities.EntityArtist;
import model.Album;
import model.Artist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandermiheev on 08.06.16.
 */
public class ArtistConverter {
    public static EntityArtist convertToEntityArtist(Artist artist) {
        String artistName = artist.getArtistName();
        List<Album> albumList = artist.getAlbumList();

        List<EntityAlbum> entityAlbumList = new ArrayList<>();

        for (Album album: albumList) {
            entityAlbumList.add(AlbumConverter.convertToEntityAlbum(album));
        }

        return new EntityArtist(artistName, entityAlbumList);
    }
    public static Artist convertToArtist(EntityArtist entityArtist) {
        String entityArtistName = entityArtist.getEntityArtistName();
        List<EntityAlbum> entityAlbumList = entityArtist.getEntityAlbumList();

        List<Album> albumList = new ArrayList<>();

        for (EntityAlbum entityAlbum: entityAlbumList) {
            albumList.add(AlbumConverter.convertToAlbum(entityAlbum));
        }

        return new Artist(entityArtistName, albumList);
    }

}
