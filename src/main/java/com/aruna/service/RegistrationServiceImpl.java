package com.aruna.service;

import com.aruna.dao.RoleDto;
import com.aruna.dao.UserDto;
import com.aruna.dao.UserRegistrationDto;
import com.aruna.model.Role;
import com.aruna.model.User;
import com.aruna.model.UserRegistration;
import com.aruna.model.UserRole;
import com.aruna.repository.RoleRepository;
import com.aruna.repository.UserRegistrationRepository;
import com.aruna.repository.UserRepository;
import com.aruna.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl {

    @Autowired
    UserRegistrationRepository userRegistrationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    public UserRegistration registration(UserRegistrationDto userRegistrationDto) throws Exception {
        UserRegistration userRegistration = new UserRegistration(userRegistrationDto);
        UserDto userDto = userRegistrationDto.getUser();
        User user = userRepository.findByUserName(userDto.getUserName());
           if (user != null) {
               throw new Exception("User already exist");
           }
        userRegistration = userRegistrationRepository.saveAndFlush(userRegistration);
        User user1 = new User(userDto, userRegistration);
        user1.setPassword(passwordEncoder.encode(user1.getPassword()));
        User finalUser = userRepository.saveAndFlush(user1);
        List<RoleDto> roleDto = userDto.getRoles();
        List<Role> roles = roleDto.stream().map(r -> new Role(r)).collect(Collectors.toList());
        roles = roleRepository.saveAll(roles);
        List<UserRole> userRoles = roles.stream().map(r -> new UserRole(finalUser, r)).collect(Collectors.toList());
        userRoleRepository.saveAll(userRoles);

        return userRegistration;
    }

    public List<User> getUsers() {
       return  userRepository.findAll();
    }

}
