package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "quality", schema = "public", catalog = "theatre")
public class QualityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "voice")
    private String voice;
    @Basic
    @Column(name = "height")
    private String height;
    @Basic
    @Column(name = "age")
    private String age;
    @Basic
    @Column(name = "gender")
    private String gender;
    @OneToMany(mappedBy = "qualityByQualityId")
    private Collection<ActorEntity> actorsById;
    @OneToMany(mappedBy = "qualityByQualityId")
    private Collection<RoleEntity> rolesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QualityEntity that = (QualityEntity) o;
        return id == that.id && Objects.equals(voice, that.voice) && Objects.equals(height, that.height) && Objects.equals(age, that.age) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, voice, height, age, gender);
    }

    public Collection<ActorEntity> getActorsById() {
        return actorsById;
    }

    public void setActorsById(Collection<ActorEntity> actorsById) {
        this.actorsById = actorsById;
    }

    public Collection<RoleEntity> getRolesById() {
        return rolesById;
    }

    public void setRolesById(Collection<RoleEntity> rolesById) {
        this.rolesById = rolesById;
    }
}
