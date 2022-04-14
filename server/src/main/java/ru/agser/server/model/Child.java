package ru.agser.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
public class Child {
    @Id
    @SequenceGenerator(
            name = "child_sequence",
            sequenceName = "child_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "child_sequence"
    )
    private Long id;

    @OneToOne
    @JoinColumn(
            name = "parent_id",
            referencedColumnName = "id"
    )
    @JsonManagedReference
    private Parent parent;

    @ManyToOne
    @JoinColumn(
            name = "squad_id",
            referencedColumnName = "id"
    )
    @JsonBackReference
    private Squad squad;

    private String name;
    private String surname;
    private String patronymic;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate dateBirth;
    private int birthCertificateNumber;
    private String address;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Child child = (Child) o;
        return id != null && Objects.equals(id, child.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
