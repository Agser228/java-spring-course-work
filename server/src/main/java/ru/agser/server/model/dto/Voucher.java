package ru.agser.server.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.agser.server.enumeration.VoucherStatus;
import ru.agser.server.security.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Voucher {
    @Id
    @SequenceGenerator(
            name = "voucher_sequence",
            sequenceName = "voucher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "voucher_sequence"
    )
    private Long id;

    @OneToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private User user;
    private LocalDateTime timeStamp;
    private VoucherStatus status;
    private String message;

    // parent
    private String parentName;
    private String parentSurname;
    private String parentPatronymic;

    private String parentPlaceIssuePassport;
    private String parentSeriesNumberPassport;
    private String parentPhoneNumber;
    private String parentAddress;


    // child
    private String childName;
    private String childSurname;
    private String childPatronymic;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate childDateBirth;
    private int childBirthCertificateNumber;
    private String childAddress;
    private int childAge;

    public void setStatus(VoucherStatus status) {
        this.status = status;
        this.message = status.getMessage();
    }
}
