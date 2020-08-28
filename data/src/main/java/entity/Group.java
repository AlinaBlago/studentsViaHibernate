package entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "groups")
public class Group extends AbstractEntity {

    private String value;

    public Group() {}

    public Group(String value){
        this.value = value;
    }

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
        return "Id group: " + getId() + ", name of group: " + getValue();
    }
}
