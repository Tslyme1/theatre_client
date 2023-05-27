package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "playdirectormap", schema = "public", catalog = "theatre")
public class PlaydirectormapEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id", nullable = false)
    private DirectorEntity directorByDirectorId;
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
        PlaydirectormapEntity that = (PlaydirectormapEntity) o;
        return id == that.id && directorByDirectorId.getId() == that.directorByDirectorId.getId() && playByPlayId.getId() == that.playByPlayId.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, directorByDirectorId, playByPlayId);
    }

    public DirectorEntity getDirectorByDirectorId() {
        return directorByDirectorId;
    }

    public void setDirectorByDirectorId(DirectorEntity directorByDirectorId) {
        this.directorByDirectorId = directorByDirectorId;
    }

    public PlayEntity getPlayByPlayId() {
        return playByPlayId;
    }

    public void setPlayByPlayId(PlayEntity playByPlayId) {
        this.playByPlayId = playByPlayId;
    }
}
