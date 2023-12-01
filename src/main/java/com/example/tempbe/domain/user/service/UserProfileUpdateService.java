package com.example.tempbe.domain.user.service;

import com.example.tempbe.domain.user.controller.request.UserProfileUpdateRequest;
import com.example.tempbe.domain.user.domain.User;
import com.example.tempbe.domain.user.domain.UserRepository;
import com.example.tempbe.domain.user.exception.IsEmptyException;
import com.example.tempbe.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserProfileUpdateService {
    private final UserRepository userRepository;

    @Transactional
    public void execute(UserProfileUpdateRequest request){
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(request.getUserId().isEmpty() || request.getName().isEmpty() || request.getDepartment().isEmpty() || request.getContact().isEmpty()){
            throw IsEmptyException.EXCEPTION;
        }
        
        user.updateUserProfile(
                request.getUserId(),
                request.getName(),
                request.getDepartment(),
                request.getContact()
        );

        userRepository.save(user);
    }
}
