package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "director", schema = "public", catalog = "theatre")
public class DirectorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "employee_id")
    private int employeeId;
    @OneToMany(mappedBy = "directorByApprovedBy")
    private Collection<EventEntity> eventsById;
    @OneToMany(mappedBy = "directorByDirectorId")
    private Collection<PlaydirectormapEntity> playdirectormapsById;
    @OneToMany(mappedBy = "directorByApprovedBy")
    private Collection<RepertoireEntity> repertoiresById;

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
        DirectorEntity that = (DirectorEntity) o;
        return id == that.id && employeeId == that.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId);
    }

    public Collection<EventEntity> getEventsById() {
        return eventsById;
    }

    public void setEventsById(Collection<EventEntity> eventsById) {
        this.eventsById = eventsById;
    }

    public Collection<PlaydirectormapEntity> getPlaydirectormapsById() {
        return playdirectormapsById;
    }

    public void setPlaydirectormapsById(Collection<PlaydirectormapEntity> playdirectormapsById) {
        this.playdirectormapsById = playdirectormapsById;
    }

    public Collection<RepertoireEntity> getRepertoiresById() {
        return repertoiresById;
    }

    public void setRepertoiresById(Collection<RepertoireEntity> repertoiresById) {
        this.repertoiresById = repertoiresById;
    }
}
