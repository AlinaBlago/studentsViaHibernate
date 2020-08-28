package entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student extends AbstractEntity {

    private String name;
    private String lastName;
    private Group group;
    private Course course;

    public Student() {}

    public Student(String name, String lastName, Group group, Course course){
        this.name = name;
        this.lastName =  lastName;
        this.group = group;
        this.course = course;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    @ManyToOne(fetch = FetchType.LAZY)
   // @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_group")
    public Group getGroup() {
        return group;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    //@ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_course")
    public Course getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Name of student: " + getName() + ", last name" + getLastName();
    }
}
