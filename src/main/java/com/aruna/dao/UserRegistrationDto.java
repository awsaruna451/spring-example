package com.aruna.dao;


import lombok.*;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {

    private int reg_id;
    @NotBlank(message = "First name can't be empty")
    private String firstName;
    @NotBlank(message = "Last name can't be empty")
    private String lastName;
    @NotBlank(message = "Gender is required")
    private String gender;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private UserDto user;
}
