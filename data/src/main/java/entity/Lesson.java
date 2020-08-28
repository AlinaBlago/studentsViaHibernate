package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "lessons")
public class Lesson extends AbstractEntity {

    private String value;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    private Theme id_theme;
    private Teacher id_teacher;
    private Group id_group;

    public Lesson() {}

    @Column(name = "nameOfLesson", nullable = false)
    public String getValue() {
        return value;
    }

    @Column(name = "startTime", nullable = false)
    public LocalTime getStartTime() {
        return startTime;
    }

    @Column(name = "endTime", nullable = false)
    public LocalTime getEndTime() {
        return endTime;
    }

    @Column(name = "date", nullable = false)
    public LocalDate getDate() {
        return date;
    }

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_theme", nullable = false)
    public Theme getId_theme() {
        return id_theme;
    }

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_teacher", nullable = false)
    public Teacher getId_teacher() {
        return id_teacher;
    }

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_group", nullable = false)
    public Group getId_group() {
        return id_group;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setId_theme(Theme id_theme) {
        this.id_theme = id_theme;
    }

    public void setId_teacher(Teacher teacher) {
        this.id_teacher = teacher;
    }

    public void setId_group(Group id_group) {
        this.id_group = id_group;
    }
}
