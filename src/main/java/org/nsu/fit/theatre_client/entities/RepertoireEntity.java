package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "repertoire", schema = "public", catalog = "theatre")
public class RepertoireEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "approved")
    private boolean approved;
    @ManyToOne
    @JoinColumn(name = "approved_by", referencedColumnName = "id", nullable = false)
    private DirectorEntity directorByApprovedBy;
    @OneToMany(mappedBy = "repertoireByRepertoireId")
    private Collection<RepertoireeventmapEntity> repertoireeventmapsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepertoireEntity that = (RepertoireEntity) o;
        return id == that.id && approved == that.approved && directorByApprovedBy.getId() == that.directorByApprovedBy.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, approved, directorByApprovedBy);
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
}
