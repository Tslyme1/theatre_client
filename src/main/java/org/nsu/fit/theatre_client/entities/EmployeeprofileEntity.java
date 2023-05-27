package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "employeeprofile", schema = "public", catalog = "theatre")
public class EmployeeprofileEntity {
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
    @Column(name = "birth_dt")
    private Date birthDt;
    @Basic
    @Column(name = "kids_count")
    private int kidsCount;
    @Basic
    @Column(name = "gender")
    private String gender;
    @OneToMany(mappedBy = "employeeprofileByProfile")
    private Collection<EmployeeEntity> employeesById;

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

    public Date getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(Date birthDt) {
        this.birthDt = birthDt;
    }

    public int getKidsCount() {
        return kidsCount;
    }

    public void setKidsCount(int kidsCount) {
        this.kidsCount = kidsCount;
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
        EmployeeprofileEntity that = (EmployeeprofileEntity) o;
        return id == that.id && kidsCount == that.kidsCount && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(patronymicName, that.patronymicName) && Objects.equals(birthDt, that.birthDt) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, patronymicName, birthDt, kidsCount, gender);
    }

    public Collection<EmployeeEntity> getEmployeesById() {
        return employeesById;
    }

    public void setEmployeesById(Collection<EmployeeEntity> employeesById) {
        this.employeesById = employeesById;
    }
}
