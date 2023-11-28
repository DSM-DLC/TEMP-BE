package com.example.tempbe.domain.info.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InfoRepository extends JpaRepository<Info, UUID> {
    Page<Info> findByName(Pageable pageable,String name);
    Page<Info> findByNameAndBirthDate(Pageable pageable,String name, Date birthDate);
    Optional<Info> findByNameAndBirthDateAndAddress(String name, Date birthDate, String address);
    Page<Info> findAll(Pageable pageable);
}
