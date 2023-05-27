package org.nsu.fit.theatre_client.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employeeattribute", schema = "public", catalog = "theatre")
public class EmployeeattributeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "value")
    private String value;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private EmployeeEntity employeeByEmployeeId;
    @ManyToOne
    @JoinColumn(name = "attribute_id", referencedColumnName = "id", nullable = false)
    private AttributeEntity attributeByAttributeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeattributeEntity that = (EmployeeattributeEntity) o;
        return id == that.id && employeeByEmployeeId.getId() == that.employeeByEmployeeId.getId() && attributeByAttributeId.getId() == that.attributeByAttributeId.getId() && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeByEmployeeId.getId(), attributeByAttributeId.getId(), value);
    }

    public EmployeeEntity getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(EmployeeEntity employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    public AttributeEntity getAttributeByAttributeId() {
        return attributeByAttributeId;
    }

    public void setAttributeByAttributeId(AttributeEntity attributeByAttributeId) {
        this.attributeByAttributeId = attributeByAttributeId;
    }
}
