package com.example.tempbe.domain.admin.service;

import com.example.tempbe.domain.admin.controller.response.AdminProfileResponse;
import com.example.tempbe.domain.admin.domain.Admin;
import com.example.tempbe.domain.admin.domain.AdminRepository;
import com.example.tempbe.domain.admin.exception.AdminNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AdminProfileService {
    private final AdminRepository adminRepository;

    @Transactional
    public AdminProfileResponse execute(){
        String adminId = SecurityContextHolder.getContext().getAuthentication().getName();

        Admin admin = adminRepository.findByAdminId(adminId)
                .orElseThrow(() -> AdminNotFoundException.EXCEPTION);

        return AdminProfileResponse.builder()
                .adminId(admin.getAdminId())
                .build();
    }
}
