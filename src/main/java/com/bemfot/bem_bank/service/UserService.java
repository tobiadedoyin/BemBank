package com.bemfot.bem_bank.service;

import com.bemfot.bem_bank.dto.AccountInfo;
import com.bemfot.bem_bank.dto.request.UserRequestDto;
import com.bemfot.bem_bank.dto.response.UserResponseDto;
import com.bemfot.bem_bank.entity.User;
import com.bemfot.bem_bank.enums.UserAccountEnum;
import com.bemfot.bem_bank.exception.BadRequestException;
import com.bemfot.bem_bank.exception.NotFoundException;
import com.bemfot.bem_bank.repository.UserRepository;
import com.bemfot.bem_bank.util.AccountUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;

@Service
public class UserService {

   private  UserRepository userRepository;

   public UserService(UserRepository userRepository){
       this.userRepository = userRepository;
   }
    public UserResponseDto createUser(UserRequestDto userRequestDto){
        if(userRepository.existsByEmail(userRequestDto.getEmail())) {
           throw  new BadRequestException("User already exist");
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
       return UserResponseDto.builder()
               .statusCode("201")
               .message("User account created")
               .accountInfo(AccountInfo.builder()
                       .accountName(savedUser.getFirstName())
                       .accountNumber(savedUser.getAccountNumber())
                       .accountBalance(savedUser.getAccountBalance())
                       .build())
               .build();

    }

}
