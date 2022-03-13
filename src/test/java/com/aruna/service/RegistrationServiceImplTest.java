package com.aruna.service;

import com.aruna.dao.RoleDto;
import com.aruna.dao.UserDto;
import com.aruna.dao.UserRegistrationDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = {RegistrationServiceImpl.class})
@AutoConfigureMockMvc
@ComponentScan({"com.aruna"})
public class RegistrationServiceImplTest {

    @Autowired
    RegistrationServiceImpl registrationService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void registration() throws Exception {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setFirstName("Aruna");
        userRegistrationDto.setLastName("Kumara");
        userRegistrationDto.setGender("Male");
        userRegistrationDto.setReg_id(1);
    /*    List<RoleDto> roleDtos = new ArrayList<>();
        roleDtos.add(new RoleDto(1, "ADMIN_USER"));
        userRegistrationDto.setUser(new UserDto(1,"aruna@gmail.com","abc123",roleDtos));*/
        registrationService.registration(userRegistrationDto);
    }
}