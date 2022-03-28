package ru.agser.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long childId;

    private String name;
    private String surname;
    private String patronymic;

    private String placeIssuePassport;
    private String seriesNumberPassport;
    private String phoneNumber;
    private String address;
}
