package com.example.tempbe.domain.admin.service;

import com.example.tempbe.domain.admin.controller.request.IssueRequest;
import com.example.tempbe.domain.admin.exception.IssueAlreadyExistsException;
import com.example.tempbe.domain.user.domain.User;
import com.example.tempbe.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AdminIssueService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(IssueRequest request) {
        if (userRepository.findByUserId(request.getUserId()).isPresent()) {
            throw IssueAlreadyExistsException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .name(request.getName())
                .userId(request.getUserId())
                .contact(request.getContact())
                .password(passwordEncoder.encode(request.getPassword()))
                .department(request.getDepartment())
                .build());
    }
}
