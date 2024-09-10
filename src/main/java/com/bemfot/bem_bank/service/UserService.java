package com.bemfot.bem_bank.service;

import com.bemfot.bem_bank.dto.request.UserRequestDto;
import com.bemfot.bem_bank.dto.response.UserResponseDto;
import com.bemfot.bem_bank.entity.User;
import com.bemfot.bem_bank.enums.UserAccountEnum;
import com.bemfot.bem_bank.repository.UserRepository;
import com.bemfot.bem_bank.util.AccountUtils;
import com.bemfot.bem_bank.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;

@Service
public class UserService {

   private  UserRepository userRepository;

   public UserService(UserRepository userRepository){
       this.userRepository = userRepository;
   }
    public ResponseEntity<Object> createUser(UserRequestDto userRequestDto){
        if(userRepository.existsByEmail(userRequestDto.getEmail())) {
           return Response.errorResponse(HttpStatus.BAD_REQUEST, "User already exist");
        }
        User newUser = User.builder()
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .otherName(userRequestDto.getOtherName())
                .gender(userRequestDto.getEmail())
                .address(userRequestDto.getAddress())
                .stateOfOrigin(userRequestDto.getStateOfOrigin())
                .email(userRequestDto.getEmail())
                .phoneNumber(userRequestDto.getPhoneNumber())
                .alternativePhoneNumber(userRequestDto.getAlternativePhoneNumber())
                .status(UserAccountEnum.ACTIVE)
                .accountNumber(AccountUtils.createAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .build();

       User savedUser = userRepository.save(newUser);
       return Response.successResponse("User account created", savedUser, HttpStatus.CREATED);

    }
}
