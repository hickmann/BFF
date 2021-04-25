package ch.hickmann.isobar.fm.bff.domains;

public class Track{
    public String name;
    public int duration;
    public String id;

    public static Builder builder() { return new Builder(); }

    public Track() {
    }

    public Track(String name, int duration, String id) {
        this.name = name;
        this.duration = duration;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static final class Builder {
        public String name;
        public int duration;
        public String id;

        private Builder() {
        }

        public static Builder aTrack() {
            return new Builder();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Track build() {
            Track track = new Track();
            track.setName(name);
            track.setDuration(duration);
            track.setId(id);
            return track;
        }
    }
}
