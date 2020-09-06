package entity;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;


@Entity
@Table(name = "themes")
public class Theme extends AbstractEntity {

    private String value;

    public Theme() {
    }

    @Column(name = "value", nullable = false)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
