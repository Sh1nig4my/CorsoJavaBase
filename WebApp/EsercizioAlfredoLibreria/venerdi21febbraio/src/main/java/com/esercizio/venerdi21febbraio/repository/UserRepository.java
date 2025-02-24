package com.esercizio.venerdi21febbraio.repository;

import com.esercizio.venerdi21febbraio.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, BigInteger> {


    Optional<Users> findByEmail(String email);
}
