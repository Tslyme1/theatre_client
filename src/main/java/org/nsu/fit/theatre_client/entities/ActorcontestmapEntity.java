package org.nsu.fit.theatre_client.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "actorcontestmap", schema = "public", catalog = "theatre")
public class ActorcontestmapEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "winner")
    private boolean winner;
    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "id", nullable = false)
    private ActorEntity actorByActorId;
    @ManyToOne
    @JoinColumn(name = "contest_id", referencedColumnName = "id", nullable = false)
    private ContestEntity contestByContestId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorcontestmapEntity that = (ActorcontestmapEntity) o;
        return id == that.id && actorByActorId.getId() == that.actorByActorId.getId() && contestByContestId.getId() == that.contestByContestId.getId() && winner == that.winner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actorByActorId.getId(), contestByContestId.getId(), winner);
    }

    public ActorEntity getActorByActorId() {
        return actorByActorId;
    }

    public void setActorByActorId(ActorEntity actorByActorId) {
        this.actorByActorId = actorByActorId;
    }

    public ContestEntity getContestByContestId() {
        return contestByContestId;
    }

    public void setContestByContestId(ContestEntity contestByContestId) {
        this.contestByContestId = contestByContestId;
    }
}
