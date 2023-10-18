package com.example.tempbe.global.security.auth;

import com.example.tempbe.domain.admin.domain.Admin;
import com.example.tempbe.domain.admin.domain.AdminRepository;
import com.example.tempbe.domain.admin.exception.AdminNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;

    @Override
    public AdminDetails loadUserByUsername(String adminId) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByAdminId(adminId)
                .orElseThrow(() -> AdminNotFoundException.EXCEPTION);
        return new AdminDetails(admin.getAdminId());
    }
}
