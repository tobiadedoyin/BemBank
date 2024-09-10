package com.bemfot.bem_bank.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.Year;

public class AccountUtils {
    /*
    * generate unique bank account number
    * */
    public static String createAccountNumber(){
        Year currentYear = Year.now();

       int sixDigit = (int) Math.floor(Math.random() * 1000000);
       String formattedSixDigit = String.valueOf(sixDigit);
       String formattedCurrentYear = String.valueOf(currentYear);

       String accountNumber = formattedCurrentYear.concat(formattedSixDigit);
       return accountNumber;
    }
}
