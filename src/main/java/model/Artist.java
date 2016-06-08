package model;

import java.util.List;

/**
 * Created by alexandermiheev on 08.06.16.
 */
public class Artist {
    private String artistName;
    private List<Album> albumList;

    public Artist(String artistName, List<Album> albumList) {
        this.artistName = artistName;
        this.albumList = albumList;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }
}
