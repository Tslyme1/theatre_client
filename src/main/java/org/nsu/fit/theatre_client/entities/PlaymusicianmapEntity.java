package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "playmusicianmap", schema = "public", catalog = "theatre")
public class PlaymusicianmapEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "musician_id", referencedColumnName = "id", nullable = false)
    private MusicianEntity musicianByMusicianId;
    @ManyToOne
    @JoinColumn(name = "play_id", referencedColumnName = "id", nullable = false)
    private PlayEntity playByPlayId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaymusicianmapEntity that = (PlaymusicianmapEntity) o;
        return id == that.id && musicianByMusicianId.getId() == that.musicianByMusicianId.getId() && playByPlayId.getId() == that.playByPlayId.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, musicianByMusicianId, playByPlayId);
    }

    public MusicianEntity getMusicianByMusicianId() {
        return musicianByMusicianId;
    }

    public void setMusicianByMusicianId(MusicianEntity musicianByMusicianId) {
        this.musicianByMusicianId = musicianByMusicianId;
    }

    public PlayEntity getPlayByPlayId() {
        return playByPlayId;
    }

    public void setPlayByPlayId(PlayEntity playByPlayId) {
        this.playByPlayId = playByPlayId;
    }
}
