package com.bemfot.bem_bank.dto.request;

import com.bemfot.bem_bank.enums.UserAccountEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private  String otherName;
    @NotNull
    private String gender;
    @NotNull
    private String address;
    @NotNull
    private  String stateOfOrigin;
    @NotNull @Email
    private String email;
    @NotNull
    private  String phoneNumber;
    private String alternativePhoneNumber;
    @Enumerated
    private UserAccountEnum status;
}
