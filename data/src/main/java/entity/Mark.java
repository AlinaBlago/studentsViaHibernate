package entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "marks")
public class Mark extends AbstractEntity {

    private Long value;
    private Lesson lesson;
    private Student student;

    public Mark() {}

    @NaturalId
    @Column(name = "value", nullable = false)
    public Long getValue() {
        return value;
    }

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_lesson")
    public Lesson getLesson() {
        return lesson;
    }

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    public Student getStudent() {
        return student;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
