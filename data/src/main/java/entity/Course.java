package entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;


@Entity
@Table(name = "courses")
public class Course extends AbstractEntity {

    private String value;

    public Course() {}

    @NaturalId
    @Column(name = "value", nullable = false)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + ",value: " + getValue();
    }
}
