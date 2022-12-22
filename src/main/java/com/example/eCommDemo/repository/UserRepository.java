package com.example.eCommDemo.repository;

import com.example.eCommDemo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(value = "select * from users u where u.email=:email", nativeQuery = true)
    public Users findByEmail(String email);

    Users findByUsername(String username);
}
