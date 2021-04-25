package ch.hickmann.isobar.fm.bff.domains;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Band {
    private String id;
    private String name;
    private String image;
    private String genre;
    private String biography;
    private Integer numPlays;
    private List<List<Album>> albumList;
    private List<String> albums;

    public static Builder builder() { return new Builder(); }

    public Band() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getNumPlays() {
        return numPlays;
    }

    public void setNumPlays(Integer numPlays) {
        this.numPlays = numPlays;
    }

    public List<List<Album>> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<List<Album>> albumList) {
        this.albumList = albumList;
    }

    public List<String> getAlbums() {
        return albums;
    }

    public void setAlbums(List<String> albums) {
        this.albums = albums;
    }

    public static final class Builder {
        private String id;
        private String name;
        private String image;
        private String genre;
        private String biography;
        private Integer numPlays;
        private List<List<Album>> albumList;
        private List<String> albums;

        private Builder() {
        }

        public static Builder aBand() {
            return new Builder();
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder biography(String biography) {
            this.biography = biography;
            return this;
        }

        public Builder numPlays(Integer numPlays) {
            this.numPlays = numPlays;
            return this;
        }

        public Builder albumList(List<List<Album>> albumList) {
            this.albumList = albumList;
            return this;
        }

        public Builder albums(List<String> albums) {
            this.albums = albums;
            return this;
        }

        public Band build() {
            Band band = new Band();
            band.setId(id);
            band.setName(name);
            band.setImage(image);
            band.setGenre(genre);
            band.setBiography(biography);
            band.setNumPlays(numPlays);
            band.setAlbumList(albumList);
            band.setAlbums(albums);
            return band;
        }
    }
}
