package ru.agser.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
public class Squad {
    @Id
    @SequenceGenerator(
            name = "squad_sequence",
            sequenceName = "squad_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "squad_sequence"
    )
    private Long id;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(
            name = "worker_id",
            referencedColumnName = "id"
    )
    private Worker worker;

    @OneToMany(
            cascade = {CascadeType.REMOVE, CascadeType.REFRESH},
            mappedBy = "squad",
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Child> children;

    @ManyToOne
    @JoinColumn(
            name = "squad_id",
            referencedColumnName = "id"
    )
    @JsonBackReference
    private Shift shift;

    private int number;
    private int averageAgeChildren;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Squad squad = (Squad) o;
        return id != null && Objects.equals(id, squad.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
