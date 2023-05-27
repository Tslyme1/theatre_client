package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "role", schema = "public", catalog = "theatre")
public class RoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "is_main")
    private boolean isMain;
    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "id", nullable = false)
    private ActorEntity actorByActorId;
    @ManyToOne
    @JoinColumn(name = "backup", referencedColumnName = "id", nullable = false)
    private ActorEntity actorByBackup;
    @ManyToOne
    @JoinColumn(name = "quality_id", referencedColumnName = "id", nullable = false)
    private QualityEntity qualityByQualityId;
    @OneToMany(mappedBy = "roleByRoleId")
    private Collection<RoleplaymapEntity> roleplaymapsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return id == that.id && actorByActorId.getId() == that.actorByActorId.getId()&& actorByBackup.getId() == that.actorByBackup.getId() && isMain == that.isMain && qualityByQualityId.getId() == that.qualityByQualityId.getId() && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actorByActorId, actorByBackup, name, isMain, qualityByQualityId);
    }

    public ActorEntity getActorByActorId() {
        return actorByActorId;
    }

    public void setActorByActorId(ActorEntity actorByActorId) {
        this.actorByActorId = actorByActorId;
    }

    public ActorEntity getActorByBackup() {
        return actorByBackup;
    }

    public void setActorByBackup(ActorEntity actorByBackup) {
        this.actorByBackup = actorByBackup;
    }

    public QualityEntity getQualityByQualityId() {
        return qualityByQualityId;
    }

    public void setQualityByQualityId(QualityEntity qualityByQualityId) {
        this.qualityByQualityId = qualityByQualityId;
    }

    public Collection<RoleplaymapEntity> getRoleplaymapsById() {
        return roleplaymapsById;
    }

    public void setRoleplaymapsById(Collection<RoleplaymapEntity> roleplaymapsById) {
        this.roleplaymapsById = roleplaymapsById;
    }
}
