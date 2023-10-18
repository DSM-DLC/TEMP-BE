package com.example.tempbe.domain.auth.domain;

import com.example.tempbe.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class RefreshToken extends BaseIdEntity {

    private String token;

    public RefreshToken(String token) {
        this.token = token;
    }

    public RefreshToken update(String token) {
        this.token = token;
        return this;
    }
}