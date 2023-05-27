package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "playproducermap", schema = "public", catalog = "theatre")
public class PlayproducermapEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "id", nullable = false)
    private ProducerEntity producerByProducerId;
    @ManyToOne
    @JoinColumn(name = "play_id", referencedColumnName = "id", nullable = false)
    private PlayEntity playByPlayId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayproducermapEntity that = (PlayproducermapEntity) o;
        return id == that.id && producerByProducerId.getId() == that.producerByProducerId.getId() && playByPlayId.getId() == that.playByPlayId.getId() && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playByPlayId, role, producerByProducerId);
    }

    public ProducerEntity getProducerByProducerId() {
        return producerByProducerId;
    }

    public void setProducerByProducerId(ProducerEntity producerByProducerId) {
        this.producerByProducerId = producerByProducerId;
    }

    public PlayEntity getPlayByPlayId() {
        return playByPlayId;
    }

    public void setPlayByPlayId(PlayEntity playByPlayId) {
        this.playByPlayId = playByPlayId;
    }
}
