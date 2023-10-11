package com.example.tempbe.domain.category.domain;

import com.example.tempbe.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Category extends BaseIdEntity {
    @Column(nullable = false, length = 30)
    private String departmentName;

    @Builder
    public Category(String departmentName){
        this.departmentName = departmentName;
    }
}
