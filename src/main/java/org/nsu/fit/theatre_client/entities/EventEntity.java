package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "event", schema = "public", catalog = "theatre")
public class EventEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "start_dt")
    private Timestamp startDt;
    @Basic
    @Column(name = "seats_left")
    private int seatsLeft;
    @Basic
    @Column(name = "premiere")
    private boolean premiere;
    @Basic
    @Column(name = "approved")
    private boolean approved;
    @Basic
    @Column(name = "end_dt")
    private Timestamp endDt;
    @ManyToOne
    @JoinColumn(name = "play_id", referencedColumnName = "id", nullable = false)
    private PlayEntity playByPlayId;
    @ManyToOne
    @JoinColumn(name = "approved_by", referencedColumnName = "id", nullable = false)
    private DirectorEntity directorByApprovedBy;
    @OneToMany(mappedBy = "eventByEventId")
    private Collection<RepertoireeventmapEntity> repertoireeventmapsById;
    @OneToMany(mappedBy = "eventByEventId")
    private Collection<TicketEntity> ticketsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Timestamp getStartDt() {
        return startDt;
    }

    public void setStartDt(Timestamp startDt) {
        this.startDt = startDt;
    }

    public int getSeatsLeft() {
        return seatsLeft;
    }

    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft = seatsLeft;
    }

    public boolean isPremiere() {
        return premiere;
    }

    public void setPremiere(boolean premiere) {
        this.premiere = premiere;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Timestamp getEndDt() {
        return endDt;
    }

    public void setEndDt(Timestamp endDt) {
        this.endDt = endDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventEntity that = (EventEntity) o;
        return id == that.id && playByPlayId.getId() == that.playByPlayId.getId() && directorByApprovedBy.getId() == that.directorByApprovedBy.getId() && seatsLeft == that.seatsLeft && premiere == that.premiere && approved == that.approved && Objects.equals(startDt, that.startDt) && Objects.equals(endDt, that.endDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playByPlayId, directorByApprovedBy, startDt, seatsLeft, premiere, approved, endDt);
    }

    public PlayEntity getPlayByPlayId() {
        return playByPlayId;
    }

    public void setPlayByPlayId(PlayEntity playByPlayId) {
        this.playByPlayId = playByPlayId;
    }

    public DirectorEntity getDirectorByApprovedBy() {
        return directorByApprovedBy;
    }

    public void setDirectorByApprovedBy(DirectorEntity directorByApprovedBy) {
        this.directorByApprovedBy = directorByApprovedBy;
    }

    public Collection<RepertoireeventmapEntity> getRepertoireeventmapsById() {
        return repertoireeventmapsById;
    }

    public void setRepertoireeventmapsById(Collection<RepertoireeventmapEntity> repertoireeventmapsById) {
        this.repertoireeventmapsById = repertoireeventmapsById;
    }

    public Collection<TicketEntity> getTicketsById() {
        return ticketsById;
    }

    public void setTicketsById(Collection<TicketEntity> ticketsById) {
        this.ticketsById = ticketsById;
    }
}
