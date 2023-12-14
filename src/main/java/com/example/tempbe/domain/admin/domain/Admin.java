package com.example.tempbe.domain.admin.domain;

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
public class Admin extends BaseIdEntity{
    @Column(nullable = false, length = 30)
    @NotBlank
    private String adminId;

    @Column(nullable = false, length = 300)
    @NotBlank
    private String password;

    @Builder
    public Admin(String adminId, String password){
        this.adminId = adminId;
        this.password = password;
    }

    public void AdminChangePassword(String password){
        this.password = password;
    }
}
