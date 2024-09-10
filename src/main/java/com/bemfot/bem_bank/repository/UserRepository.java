package com.bemfot.bem_bank.repository;

import com.bemfot.bem_bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
    Boolean existsByAccountNumber(String accountNumber);
}
