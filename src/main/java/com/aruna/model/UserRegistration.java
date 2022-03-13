package com.aruna.model;

import com.aruna.dao.UserRegistrationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_registrations")
public class UserRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reg_id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String gender;
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private Timestamp createdDate;
    @Column(name = "update_date", nullable = false)
    @LastModifiedDate
    private Timestamp updatedDate;
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "userRegistration")
    private User user;
    public UserRegistration(UserRegistrationDto userRegistrationDto) {
        this.reg_id = userRegistrationDto.getReg_id();
        this.firstName = userRegistrationDto.getFirstName();
        this.lastName = userRegistrationDto.getLastName();
        this.gender = userRegistrationDto.getGender();

    }
}
