package model;

import java.util.List;

/**
 * Created by alexandermiheev on 09.06.16.
 */
public class Catalogue {
    private String catalogueName;
    private List<Artist> artistList;

    public Catalogue(String catalogueName, List<Artist> artistList) {
        this.catalogueName = catalogueName;
        this.artistList = artistList;
    }

    public String getCatalogueName() {
        return catalogueName;
    }

    public void setCatalogueName(String catalogueName) {
        this.catalogueName = catalogueName;
    }

    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }
}
