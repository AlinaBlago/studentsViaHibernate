package entity;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher extends AbstractEntity {

    private String name;
    private String lastName;

    public Teacher() {}

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "lastName", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
