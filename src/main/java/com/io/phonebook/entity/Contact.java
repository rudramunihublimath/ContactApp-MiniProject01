package com.io.phonebook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
    private String contactNAME;
    @Column(name = "CONTACT_EMAIL")
    private String contactEMAIL;
    @Column(name = "CONTACT_NUMBER")
    private String contactNUMBER;
    @Column(name = "ACTIVE_SW")
    private String activeSw;

    @CreationTimestamp
    @Column(name = "CREATED_DATE",updatable = false)
    private LocalDate createdDate;

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE",insertable = false)
    private LocalDate updatedDate;
}
