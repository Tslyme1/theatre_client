package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "author", schema = "public", catalog = "theatre")
public class AuthorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "patronymic_name")
    private String patronymicName;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "birth_dt")
    private Date birthDt;
    @OneToMany(mappedBy = "authorByAuthorId")
    private Collection<PlayauthormapEntity> playauthormapsById;
    @OneToMany(mappedBy = "authorByAuthorId")
    private Collection<VoucherEntity> vouchersById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(Date birthDt) {
        this.birthDt = birthDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorEntity that = (AuthorEntity) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(patronymicName, that.patronymicName) && Objects.equals(country, that.country) && Objects.equals(birthDt, that.birthDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, patronymicName, country, birthDt);
    }

    public Collection<PlayauthormapEntity> getPlayauthormapsById() {
        return playauthormapsById;
    }

    public void setPlayauthormapsById(Collection<PlayauthormapEntity> playauthormapsById) {
        this.playauthormapsById = playauthormapsById;
    }

    public Collection<VoucherEntity> getVouchersById() {
        return vouchersById;
    }

    public void setVouchersById(Collection<VoucherEntity> vouchersById) {
        this.vouchersById = vouchersById;
    }
}
