package com.example.tempbe.domain.info.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InfoRepository extends JpaRepository<Info, UUID> {
    Optional<Info> findByNameAndBirthDate(String name, Date birthDate);
    Optional<Info> findByNameAndBirthDateAndAddress(String name, Date birthDate, String address);
}
