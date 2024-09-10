package com.bemfot.bem_bank.dto.response;

import com.bemfot.bem_bank.dto.AccountInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto  {
    private String statusCode;
    private String message;
    private AccountInfo accountInfo;
}
