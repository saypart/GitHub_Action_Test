package com.nemocompany.onegomanna.database.entity.user;

import com.nemocompany.onegomanna.database.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity(name = "users")
@SQLDelete(sql = "UPDATE users SET is_deleted = true WHERE id = ?")
@SQLRestriction(value = "is_deleted = false")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthyear;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private boolean isTermsAccepted;

    @Column(nullable = false)
    private boolean isPrivacyPolicyAccepted;

    @Builder
    public User(String name, LocalDate birthyear, String phoneNumber, Gender gender, boolean isTermsAccepted, boolean isPrivacyPolicyAccepted, LocalDateTime createdAt) {
        this.name = name;
        this.birthyear = birthyear;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.isTermsAccepted = isTermsAccepted;
        this.isPrivacyPolicyAccepted = isPrivacyPolicyAccepted;
        this.setCreatedAt(createdAt);
        this.setModifiedAt(createdAt);
    }

    public enum Gender {
        MALE, FEMALE
    }
}
