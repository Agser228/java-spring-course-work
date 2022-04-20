package ru.agser.server.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import ru.agser.server.enumeration.Position;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
public class Worker {
    @Id
    @SequenceGenerator(
            name = "worker_sequence",
            sequenceName = "worker_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "worker_sequence"
    )
    private Long id;

    private String name;
    private String surname;
    private String patronymic;

    private String placeIssuePassport;
    private String seriesNumberPassport;
    private String email;

    private Position position;
    private String phoneNumber;
    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Worker worker = (Worker) o;
        return id != null && Objects.equals(id, worker.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
