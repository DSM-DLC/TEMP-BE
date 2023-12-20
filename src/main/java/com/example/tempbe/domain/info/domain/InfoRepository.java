package com.example.tempbe.domain.info.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InfoRepository extends JpaRepository<Info, UUID> {
    Page<Info> findByNameContaining(Pageable pageable,String name);
    Page<Info> findByNameContainingAndBirthDate(Pageable pageable, String name, Date birthDate);
    Optional<Info> findByNameAndBirthDateAndAddress(String name, String birthDate, String address);
    Page<Info> findAll(Pageable pageable);
}
