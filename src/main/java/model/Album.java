package model;

import java.util.List;

/**
 * Created by alexandermiheev on 08.06.16.
 */
public class Album {
    private String albumName;
    private String albumGenre;
    private List<Track> albumTracks;

    public Album(String albumName, String albumGenre, List<Track> albumTracks) {
        this.albumName = albumName;
        this.albumGenre = albumGenre;
        this.albumTracks = albumTracks;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumGenre() {
        return albumGenre;
    }

    public void setAlbumGenre(String albumGenre) {
        this.albumGenre = albumGenre;
    }

    public List<Track> getAlbumTracks() {
        return albumTracks;
    }

    public void setAlbumTracks(List<Track> albumTracks) {
        this.albumTracks = albumTracks;
    }
}
