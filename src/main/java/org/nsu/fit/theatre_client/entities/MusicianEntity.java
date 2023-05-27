package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "musician", schema = "public", catalog = "theatre")
public class MusicianEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "employee_id")
    private int employeeId;
    @OneToMany(mappedBy = "musicianByMusicianId")
    private Collection<PlaymusicianmapEntity> playmusicianmapsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicianEntity that = (MusicianEntity) o;
        return id == that.id && employeeId == that.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId);
    }

    public Collection<PlaymusicianmapEntity> getPlaymusicianmapsById() {
        return playmusicianmapsById;
    }

    public void setPlaymusicianmapsById(Collection<PlaymusicianmapEntity> playmusicianmapsById) {
        this.playmusicianmapsById = playmusicianmapsById;
    }
}
