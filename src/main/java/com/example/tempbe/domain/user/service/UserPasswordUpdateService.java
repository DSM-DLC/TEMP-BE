package com.example.tempbe.domain.user.service;

import com.example.tempbe.domain.user.controller.request.UserPasswordUpdateRequest;
import com.example.tempbe.domain.user.domain.User;
import com.example.tempbe.domain.user.domain.UserRepository;
import com.example.tempbe.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserPasswordUpdateService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void execute(UserPasswordUpdateRequest request) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        user.updatePassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
    }
}
