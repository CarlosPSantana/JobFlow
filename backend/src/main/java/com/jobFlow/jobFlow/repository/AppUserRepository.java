package com.jobFlow.jobFlow.repository;

import java.util.Optional;
import com.jobFlow.jobFlow.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long>{
    Optional<AppUser> findByUsername(String username);
    
}
