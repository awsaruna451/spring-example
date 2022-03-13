package com.aruna.model;

import com.aruna.dao.RoleDto;
import com.aruna.dao.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "reg_id_fk", nullable = false)
    private UserRegistration userRegistration;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserRole> userRoles;
    public User(UserDto userDto, UserRegistration registration) {
        this.userId = userDto.getUserId();
        this.userName = userDto.getUserName();
        this.password = userDto.getPassword();
        this.userRegistration = registration;

    }

}
