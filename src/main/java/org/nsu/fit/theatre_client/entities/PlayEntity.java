package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "play", schema = "public", catalog = "theatre")
public class PlayEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "created_dt")
    private Date createdDt;
    @Basic
    @Column(name = "genre")
    private String genre;
    @Basic
    @Column(name = "min_age")
    private int minAge;
    @OneToMany(mappedBy = "playByPlayId")
    private Collection<EventEntity> eventsById;
    @OneToMany(mappedBy = "playByPlayId")
    private Collection<PlayauthormapEntity> playauthormapsById;
    @OneToMany(mappedBy = "playByPlayId")
    private Collection<PlaydirectormapEntity> playdirectormapsById;
    @OneToMany(mappedBy = "playByPlayId")
    private Collection<PlaymusicianmapEntity> playmusicianmapsById;
    @OneToMany(mappedBy = "playByPlayId")
    private Collection<PlayproducermapEntity> playproducermapsById;
    @OneToMany(mappedBy = "playByPlayId")
    private Collection<RoleplaymapEntity> roleplaymapsById;
    @OneToMany(mappedBy = "playByPlayId")
    private Collection<TourEntity> toursById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayEntity that = (PlayEntity) o;
        return id == that.id && minAge == that.minAge && Objects.equals(createdDt, that.createdDt) && Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDt, genre, minAge);
    }

    public Collection<EventEntity> getEventsById() {
        return eventsById;
    }

    public void setEventsById(Collection<EventEntity> eventsById) {
        this.eventsById = eventsById;
    }

    public Collection<PlayauthormapEntity> getPlayauthormapsById() {
        return playauthormapsById;
    }

    public void setPlayauthormapsById(Collection<PlayauthormapEntity> playauthormapsById) {
        this.playauthormapsById = playauthormapsById;
    }

    public Collection<PlaydirectormapEntity> getPlaydirectormapsById() {
        return playdirectormapsById;
    }

    public void setPlaydirectormapsById(Collection<PlaydirectormapEntity> playdirectormapsById) {
        this.playdirectormapsById = playdirectormapsById;
    }

    public Collection<PlaymusicianmapEntity> getPlaymusicianmapsById() {
        return playmusicianmapsById;
    }

    public void setPlaymusicianmapsById(Collection<PlaymusicianmapEntity> playmusicianmapsById) {
        this.playmusicianmapsById = playmusicianmapsById;
    }

    public Collection<PlayproducermapEntity> getPlayproducermapsById() {
        return playproducermapsById;
    }

    public void setPlayproducermapsById(Collection<PlayproducermapEntity> playproducermapsById) {
        this.playproducermapsById = playproducermapsById;
    }

    public Collection<RoleplaymapEntity> getRoleplaymapsById() {
        return roleplaymapsById;
    }

    public void setRoleplaymapsById(Collection<RoleplaymapEntity> roleplaymapsById) {
        this.roleplaymapsById = roleplaymapsById;
    }

    public Collection<TourEntity> getToursById() {
        return toursById;
    }

    public void setToursById(Collection<TourEntity> toursById) {
        this.toursById = toursById;
    }
}
