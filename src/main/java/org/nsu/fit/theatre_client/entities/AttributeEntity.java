package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "attribute", schema = "public", catalog = "theatre")
public class AttributeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "attributeByAttributeId")
    private Collection<EmployeeattributeEntity> employeeattributesById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeEntity that = (AttributeEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Collection<EmployeeattributeEntity> getEmployeeattributesById() {
        return employeeattributesById;
    }

    public void setEmployeeattributesById(Collection<EmployeeattributeEntity> employeeattributesById) {
        this.employeeattributesById = employeeattributesById;
    }
}
