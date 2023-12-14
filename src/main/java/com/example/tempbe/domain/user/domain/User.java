package com.example.tempbe.domain.user.domain;

import com.example.tempbe.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends BaseIdEntity {
    @Column(nullable = false, length = 30)
    @NotBlank
    private String userId;

    @Column(nullable = false, length = 20)
    @NotBlank
    private String name;

    @Column(nullable = false, length = 300)
    @NotBlank
    private String password;

    @Column(nullable = false, length = 30)
    @NotBlank
    private String department;

    @Column(nullable = false, length = 20)
    @NotBlank
    private String contact;

    @Builder
    public User(String userId, String name, String password, String department, String contact){
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.department = department;
        this.contact = contact;
    }


    public void updateUserProfile(String userId, String name, String department, String contact){
        this.userId = userId;
        this.name = name;
        this.department = department;
        this.contact = contact;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
