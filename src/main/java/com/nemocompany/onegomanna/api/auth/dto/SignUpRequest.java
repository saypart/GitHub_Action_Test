package com.nemocompany.onegomanna.api.auth.dto;

import com.nemocompany.onegomanna.api.auth.dto.validation.DateInRange;
import com.nemocompany.onegomanna.api.auth.dto.validation.ValidGender;
import com.nemocompany.onegomanna.database.entity.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Schema(description = "회원가입 요청 모델")
public record SignUpRequest(
        @Schema(description = "이름", example = "김네모")
        @Size(min = 1)
        @NotBlank(message = "Name cannot be blank")
        String name,

        @Schema(description = "출생년도", example = "2024-08-19")
        @NotNull(message = "Date cannot be null")
        @DateInRange(startDate = "1900-01-01", message = "Date must be between 1900-01-01 and now")
        LocalDate birthyear,

        @Schema(description = "폰 번호", example = "010-1234-5678")
        @NotBlank(message = "PhoneNumber cannot be blank")
        String phoneNumber,

        @Schema(description = "성별", example = "MALE")
        @ValidGender
        @NotNull(message = "Date cannot be null")
        String gender,

        @Schema(description = "약관 동의 여부", example = "true")
        @NotNull(message = "IsTermsAccepted cannot be null")
        String isTermsAccepted,

        @Schema(description = "개인정보정책 동의 여부", example = "true")
        @NotNull(message = "IsPrivacyPolicyAccepted cannot be null")
        String isPrivacyPolicyAccepted
) {
        public User.Gender getGenderAsGender() {
                return User.Gender.valueOf(gender);
        }
        public Boolean getIsTermsAcceptedAsBoolean() {
                return Boolean.parseBoolean(isTermsAccepted);
        }

        public Boolean getIsPrivacyPolicyAcceptedAsBoolean() {
                return Boolean.parseBoolean(isPrivacyPolicyAccepted);
        }
}