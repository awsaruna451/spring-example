package com.aruna.repository;

import com.aruna.dao.RoleDto;
import com.aruna.dao.UserDto;
import com.aruna.dao.UserRegistrationDto;
import com.aruna.model.User;
import com.aruna.model.UserRegistration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testUserAlreadyExistInUserTable() {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setFirstName("Aruna");
        userRegistrationDto.setLastName("Kumara");
        userRegistrationDto.setGender("Male");
        userRegistrationDto.setReg_id(1);
    /*    List<RoleDto> roleDtos = new ArrayList<>();
        roleDtos.add(new RoleDto(1, "ADMIN_USER"));
        userRegistrationDto.setUser(new UserDto(1,"aruna@gmail.com","abc123",roleDtos));
        UserRegistration userRegistration = new UserRegistration(userRegistrationDto);
        UserRegistration response = userRegistrationRepository.save(userRegistration);*/
    }
}