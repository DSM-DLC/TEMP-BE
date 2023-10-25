package com.example.tempbe.domain.info.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InfoRepository extends JpaRepository<Info, UUID> {
}
