package com.bemfot.bem_bank.controller;

import com.bemfot.bem_bank.dto.request.UserRequestDto;
import com.bemfot.bem_bank.dto.response.UserResponseDto;
import com.bemfot.bem_bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-account")
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto){
        return  userService.createUser(userRequestDto);
    }
}
