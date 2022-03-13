package com.aruna.dao;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int userId;
    @NotBlank(message = "Name can't be empty")
    private String userName;
    @NotBlank(message = "Password is empty")
    private String password;
    private List<RoleDto> roles;
    private List<String> ids;
}
