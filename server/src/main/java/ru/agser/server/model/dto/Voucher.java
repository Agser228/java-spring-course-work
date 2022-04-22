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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    private Long userId;

    private LocalDateTime timeStamp;
    private VoucherStatus status;
    private String message;

    // parent
    @NotBlank(message = "Поле не должно быть пустым")
    private String parentName;
    @NotBlank(message = "Поле не должно быть пустым")
    private String parentSurname;
    @NotBlank(message = "Поле не должно быть пустым")
    private String parentPatronymic;

    @NotBlank(message = "Поле не должно быть пустым")
    private String parentPlaceIssuePassport;
    @NotBlank(message = "Поле не должно быть пустым")
    private String parentSeriesNumberPassport;
    @NotBlank(message = "Поле не должно быть пустым")
    private String parentPhoneNumber;
    @NotBlank(message = "Поле не должно быть пустым")
    private String parentAddress;


    // child
    @NotBlank(message = "Поле не должно быть пустым")
    private String childName;

    @NotBlank(message = "Поле не должно быть пустым")
    private String childSurname;

    @NotBlank(message = "Поле не должно быть пустым")
    private String childPatronymic;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate childDateBirth;

    @NotNull(message = "Поле не должно быть пустым")
    @Max(2147483647)
    private int childBirthCertificateNumber;

    @NotBlank(message = "Поле не должно быть пустым")
    private String childAddress;

    @NotNull(message = "Поле не должно быть пустым")
    @Max(15)
    @Min(6)
    private int childAge;

    public void setStatus(VoucherStatus status) {
        this.status = status;
        this.message = status.getMessage();
    }
}
