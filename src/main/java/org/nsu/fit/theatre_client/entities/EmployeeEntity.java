package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "employee", schema = "public", catalog = "theatre")
public class EmployeeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "salary")
    private int salary;
    @Basic
    @Column(name = "dt_joined")
    private Date dtJoined;
    @Basic
    @Column(name = "invited_by")
    private Integer invitedBy;
    @ManyToOne
    @JoinColumn(name = "profile", referencedColumnName = "id", nullable = false)
    private EmployeeprofileEntity employeeprofileByProfile;
    @OneToMany(mappedBy = "employeeByEmployeeId")
    private Collection<EmployeeattributeEntity> employeeattributesById;
    @OneToMany(mappedBy = "employeeByEmployeeId")
    private Collection<EmployeecategoryEntity> employeecategoriesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDtJoined() {
        return dtJoined;
    }

    public void setDtJoined(Date dtJoined) {
        this.dtJoined = dtJoined;
    }

    public Integer getInvitedBy() {
        return invitedBy;
    }

    public void setInvitedBy(Integer invitedBy) {
        this.invitedBy = invitedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return id == that.id && employeeprofileByProfile.getId() == that.employeeprofileByProfile.getId() && salary == that.salary && Objects.equals(dtJoined, that.dtJoined) && Objects.equals(invitedBy, that.invitedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeprofileByProfile.getId(), salary, dtJoined, invitedBy);
    }

    public EmployeeprofileEntity getEmployeeprofileByProfile() {
        return employeeprofileByProfile;
    }

    public void setEmployeeprofileByProfile(EmployeeprofileEntity employeeprofileByProfile) {
        this.employeeprofileByProfile = employeeprofileByProfile;
    }

    public Collection<EmployeeattributeEntity> getEmployeeattributesById() {
        return employeeattributesById;
    }

    public void setEmployeeattributesById(Collection<EmployeeattributeEntity> employeeattributesById) {
        this.employeeattributesById = employeeattributesById;
    }

    public Collection<EmployeecategoryEntity> getEmployeecategoriesById() {
        return employeecategoriesById;
    }

    public void setEmployeecategoriesById(Collection<EmployeecategoryEntity> employeecategoriesById) {
        this.employeecategoriesById = employeecategoriesById;
    }
}
