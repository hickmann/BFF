package ch.hickmann.isobar.fm.bff.domains;

import java.util.Date;
import java.util.List;

public class Album {
    public String name;
    public String image;
    public Date releasedDate;
    public String band;
    public List<Track> tracks;
    public String id;

    public static Builder builder() { return new Builder(); }

    public Album() {
    }

    public Album(String name, String image, Date releasedDate, String band, List<Track> tracks, String id) {
        this.name = name;
        this.image = image;
        this.releasedDate = releasedDate;
        this.band = band;
        this.tracks = tracks;
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

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static final class Builder {
        public String name;
        public String image;
        public Date releasedDate;
        public String band;
        public List<Track> tracks;
        public String id;

        private Builder() {
        }

        public static Builder anAlbum() {
            return new Builder();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public Builder releasedDate(Date releasedDate) {
            this.releasedDate = releasedDate;
            return this;
        }

        public Builder band(String band) {
            this.band = band;
            return this;
        }

        public Builder tracks(List<Track> tracks) {
            this.tracks = tracks;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Album build() {
            Album album = new Album();
            album.setName(name);
            album.setImage(image);
            album.setReleasedDate(releasedDate);
            album.setBand(band);
            album.setTracks(tracks);
            album.setId(id);
            return album;
        }
    }
}
