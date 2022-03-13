package com.aruna.controller;
import com.aruna.dao.ApiResponse;
import com.aruna.dao.Request;
import com.aruna.dao.UserDto;
import com.aruna.dao.UserRegistrationDto;
import com.aruna.model.User;
import com.aruna.model.UserRegistration;
import com.aruna.rabbitmq.CustomMessage;
import com.aruna.rabbitmq.MQConfig;
import com.aruna.service.RegistrationServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRegistrationController {

    private RegistrationServiceImpl registrationService;
    @Autowired
    private RabbitTemplate template;

    public UserRegistrationController(RegistrationServiceImpl registrationService){

        this.registrationService = registrationService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/registration")
    public ResponseEntity<ApiResponse> userRegistration(@RequestBody UserRegistrationDto registration, HttpServletRequest request) throws Exception {

        UserRegistration userRegistration = registrationService.registration(registration);
        CustomMessage customMessage = new CustomMessage(String.valueOf(userRegistration.getReg_id()), "Registration Sucess", new Date());
        template.convertAndSend(MQConfig.message_exchange, MQConfig.MESSAGE_ROUTING_KEY, customMessage);
        return ResponseEntity.ok(new ApiResponse(true, userRegistration));
    }
    @GetMapping("/users")
    public ResponseEntity<ApiResponse> getUsers(HttpServletRequest request, final Request requestValue) throws Exception {

        if (requestValue.getIds().isEmpty()) {
            throw  new Exception("Wrong Values");
        }

        List<User> users = registrationService.getUsers();
               return ResponseEntity.ok(new ApiResponse(true, users));
    }
}
