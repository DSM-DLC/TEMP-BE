package com.example.tempbe.domain.admin.service;

import com.example.tempbe.domain.admin.controller.request.AdminChangePasswordRequest;
import com.example.tempbe.domain.admin.domain.Admin;
import com.example.tempbe.domain.admin.domain.AdminRepository;
import com.example.tempbe.domain.admin.exception.AdminNotFoundException;
import com.example.tempbe.domain.auth.exception.NotMatchesNewPasswordException;
import com.example.tempbe.domain.auth.exception.NotMatchesPasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AdminChangePasswordService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(AdminChangePasswordRequest request){
        String adminId = SecurityContextHolder.getContext().getAuthentication().getName();

        Admin admin = adminRepository.findByAdminId(adminId)
                .orElseThrow(() -> AdminNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            throw NotMatchesPasswordException.EXCEPTION;
        }

        if(!request.getNewPassword().equals(request.getNewPasswordCheck())){
            throw NotMatchesNewPasswordException.EXCEPTION;
        }

        admin.AdminChangePassword(passwordEncoder.encode(request.getNewPassword()));
    }
}
