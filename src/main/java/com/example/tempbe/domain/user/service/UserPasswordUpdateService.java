package com.example.tempbe.domain.user.service;

import com.example.tempbe.domain.auth.exception.NewPasswordMisMatchException;
import com.example.tempbe.domain.auth.exception.PasswordMisMatchException;
import com.example.tempbe.domain.user.controller.request.UserPasswordUpdateRequest;
import com.example.tempbe.domain.user.domain.User;
import com.example.tempbe.domain.user.domain.UserRepository;
import com.example.tempbe.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserPasswordUpdateService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(UserPasswordUpdateRequest request) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        if(!request.getNewPassword().equals(request.getNewPasswordCheck())){
            throw NewPasswordMisMatchException.EXCEPTION;
        }

        user.updatePassword(passwordEncoder.encode(request.getNewPassword()));
    }
}
