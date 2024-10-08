package com.bemfot.bem_bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
public class EmailService {
    private JavaMailSender mailSender;

    private ResourceLoader resourceLoader;

    @Autowired
    public  EmailService(JavaMailSender mailSender, ResourceLoader resourceLoader){
        this.mailSender = mailSender;
        this.resourceLoader = resourceLoader;
    }

    private String loadEmailFromTemplate(Resource resource ) throws IOException {
        StringBuilder content = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))){
            String line;

            while((line = reader.readLine()) != null){
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
