package edu.az.itbrains123.ecommerse.repositories;


import edu.az.itbrains123.ecommerse.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
