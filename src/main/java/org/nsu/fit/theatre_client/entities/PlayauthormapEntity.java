package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "playauthormap", schema = "public", catalog = "theatre")
public class PlayauthormapEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private AuthorEntity authorByAuthorId;
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
        PlayauthormapEntity that = (PlayauthormapEntity) o;
        return id == that.id && authorByAuthorId.getId() == that.authorByAuthorId.getId() && playByPlayId.getId() == that.playByPlayId.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorByAuthorId, playByPlayId);
    }

    public AuthorEntity getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(AuthorEntity authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }

    public PlayEntity getPlayByPlayId() {
        return playByPlayId;
    }

    public void setPlayByPlayId(PlayEntity playByPlayId) {
        this.playByPlayId = playByPlayId;
    }
}
