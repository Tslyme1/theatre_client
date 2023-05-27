package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "repertoireeventmap", schema = "public", catalog = "theatre")
public class RepertoireeventmapEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "repertoire_id", referencedColumnName = "id", nullable = false)
    private RepertoireEntity repertoireByRepertoireId;
    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false)
    private EventEntity eventByEventId;

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
        RepertoireeventmapEntity that = (RepertoireeventmapEntity) o;
        return id == that.id && repertoireByRepertoireId.getId() == that.repertoireByRepertoireId.getId() && eventByEventId.getId() == that.eventByEventId.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, repertoireByRepertoireId, eventByEventId);
    }

    public RepertoireEntity getRepertoireByRepertoireId() {
        return repertoireByRepertoireId;
    }

    public void setRepertoireByRepertoireId(RepertoireEntity repertoireByRepertoireId) {
        this.repertoireByRepertoireId = repertoireByRepertoireId;
    }

    public EventEntity getEventByEventId() {
        return eventByEventId;
    }

    public void setEventByEventId(EventEntity eventByEventId) {
        this.eventByEventId = eventByEventId;
    }
}
