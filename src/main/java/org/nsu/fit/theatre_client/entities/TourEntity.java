package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "tour", schema = "public", catalog = "theatre")
public class TourEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "start_dt")
    private Date startDt;
    @Basic
    @Column(name = "end_dt")
    private Date endDt;
    @ManyToOne
    @JoinColumn(name = "play_id", referencedColumnName = "id", nullable = false)
    private PlayEntity playByPlayId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    public Date getEndDt() {
        return endDt;
    }

    public void setEndDt(Date endDt) {
        this.endDt = endDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourEntity that = (TourEntity) o;
        return id == that.id && playByPlayId.getId() == that.playByPlayId.getId() && Objects.equals(startDt, that.startDt) && Objects.equals(endDt, that.endDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playByPlayId, startDt, endDt);
    }

    public PlayEntity getPlayByPlayId() {
        return playByPlayId;
    }

    public void setPlayByPlayId(PlayEntity playByPlayId) {
        this.playByPlayId = playByPlayId;
    }
}
