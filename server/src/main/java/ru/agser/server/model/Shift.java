package ru.agser.server.model;

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
import ru.agser.server.enumeration.ShiftStatus;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Shift {
    @Id
    @SequenceGenerator(
            name = "shift_sequence",
            sequenceName = "shift_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shift_sequence"
    )
    private Long id;

    private int number;
    private int currentYear;
    private long amountPlaces;
    private ShiftStatus status;

    @OneToMany(
            cascade = {CascadeType.REMOVE, CascadeType.REFRESH},
            mappedBy = "shift",
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Squad> squads;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Shift shift = (Shift) o;
        return id != null && Objects.equals(id, shift.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
