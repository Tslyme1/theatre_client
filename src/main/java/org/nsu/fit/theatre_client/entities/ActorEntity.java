package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "actor", schema = "public", catalog = "theatre")
public class ActorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "employee_id")
    private int employeeId;
    @Basic
    @Column(name = "honored_artist")
    private boolean honoredArtist;
    @Basic
    @Column(name = "national_artist")
    private boolean nationalArtist;
    @Basic
    @Column(name = "student")
    private boolean student;
    @ManyToOne
    @JoinColumn(name = "quality_id", referencedColumnName = "id", nullable = false)
    private QualityEntity qualityByQualityId;
    @OneToMany(mappedBy = "actorByActorId")
    private Collection<ActorcontestmapEntity> actorcontestmapsById;
    @OneToMany(mappedBy = "actorByActorId")
    private Collection<RoleEntity> rolesById;
    @OneToMany(mappedBy = "actorByBackup")
    private Collection<RoleEntity> rolesById_0;

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

    public boolean isHonoredArtist() {
        return honoredArtist;
    }

    public void setHonoredArtist(boolean honoredArtist) {
        this.honoredArtist = honoredArtist;
    }

    public boolean isNationalArtist() {
        return nationalArtist;
    }

    public void setNationalArtist(boolean nationalArtist) {
        this.nationalArtist = nationalArtist;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorEntity that = (ActorEntity) o;
        return id == that.id && employeeId == that.employeeId && honoredArtist == that.honoredArtist && nationalArtist == that.nationalArtist && student == that.student && qualityByQualityId.getId() == that.qualityByQualityId.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, honoredArtist, nationalArtist, student, qualityByQualityId.getId());
    }

    public QualityEntity getQualityByQualityId() {
        return qualityByQualityId;
    }

    public void setQualityByQualityId(QualityEntity qualityByQualityId) {
        this.qualityByQualityId = qualityByQualityId;
    }

    public Collection<ActorcontestmapEntity> getActorcontestmapsById() {
        return actorcontestmapsById;
    }

    public void setActorcontestmapsById(Collection<ActorcontestmapEntity> actorcontestmapsById) {
        this.actorcontestmapsById = actorcontestmapsById;
    }

    public Collection<RoleEntity> getRolesById() {
        return rolesById;
    }

    public void setRolesById(Collection<RoleEntity> rolesById) {
        this.rolesById = rolesById;
    }

    public Collection<RoleEntity> getRolesById_0() {
        return rolesById_0;
    }

    public void setRolesById_0(Collection<RoleEntity> rolesById_0) {
        this.rolesById_0 = rolesById_0;
    }
}
