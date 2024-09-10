package com.bemfot.bem_bank.entity;

import com.bemfot.bem_bank.enums.UserAccountEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 2)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "other_name", nullable = false)
    private  String otherName;
    @NotNull
    private String gender;
    @NotNull
    private String address;
    @Column(name = "state_of_origin", nullable = false)
    private  String stateOfOrigin;
    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;
    @Column(name = "account_balance", nullable = false)
    private BigDecimal accountBalance;
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "phone_number", nullable = false)
    private  String phoneNumber;
    @Column(name = "alternative_phone_number")
    private String alternativePhoneNumber;
    @Enumerated(EnumType.STRING)
    private UserAccountEnum status;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
