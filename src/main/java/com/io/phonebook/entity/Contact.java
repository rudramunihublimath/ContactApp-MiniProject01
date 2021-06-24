package com.io.phonebook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "CONTACT_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue
    @Column(name = "CONTACT_ID")
    private Integer contactId;

    @Column(name = "CONTACT_NAME")
    @NotEmpty(message = "Name is Mandatory")
    private String contactNAME;

    @Column(name = "CONTACT_EMAIL")
    @NotEmpty(message = "Email is Mandatory")
    @Email(message = "Please enter valid Email")
    private String contactEMAIL;

    @Column(name = "CONTACT_NUMBER")
    @NotNull(message = "Number is Mandatory")
    private Long contactNUMBER;

    @Column(name = "ACTIVE_SW")
    private String activeSw;

    @CreationTimestamp
    @Column(name = "CREATED_DATE",updatable = false)
    private LocalDate createdDate;

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE",insertable = false)
    private LocalDate updatedDate;
}
