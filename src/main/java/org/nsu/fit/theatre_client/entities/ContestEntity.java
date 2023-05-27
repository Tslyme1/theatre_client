package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "contest", schema = "public", catalog = "theatre")
public class ContestEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "date")
    private Date date;
    @OneToMany(mappedBy = "contestByContestId")
    private Collection<ActorcontestmapEntity> actorcontestmapsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContestEntity that = (ContestEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date);
    }

    public Collection<ActorcontestmapEntity> getActorcontestmapsById() {
        return actorcontestmapsById;
    }

    public void setActorcontestmapsById(Collection<ActorcontestmapEntity> actorcontestmapsById) {
        this.actorcontestmapsById = actorcontestmapsById;
    }
}
