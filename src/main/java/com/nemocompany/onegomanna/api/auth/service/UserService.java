package com.nemocompany.onegomanna.api.auth.service;

import com.nemocompany.onegomanna.api.auth.exception.AuthErrorCode;
import com.nemocompany.onegomanna.api.auth.dto.SignUpRequest;
import com.nemocompany.onegomanna.api.auth.dto.SignUpResponse;
import com.nemocompany.onegomanna.api.global.exception.RestApiException;
import com.nemocompany.onegomanna.database.entity.user.User;
import com.nemocompany.onegomanna.database.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public SignUpResponse signUp(SignUpRequest request) {
        Optional<User> optionalUserByPhoneNumber = userRepository.findOptionalUserByPhoneNumber(request.phoneNumber());

        var userId = optionalUserByPhoneNumber.map(User::getId).orElseGet(
                () -> {
                    Map<String, Boolean> policiesValueMap = Stream.of(
                            new AbstractMap.SimpleEntry<>("termsAccepted", Boolean.parseBoolean(request.isTermsAccepted())),
                            new AbstractMap.SimpleEntry<>("privacyPolicyAccepted", Boolean.parseBoolean(request.isPrivacyPolicyAccepted()))
                    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

                    checkPoliciesAccepted(policiesValueMap);
                    User newUser = User.builder()
                            .name(request.name())
                            .birthyear(request.birthyear())
                            .phoneNumber(request.phoneNumber())
                            .gender(request.getGenderAsGender())
                            .isTermsAccepted(request.getIsTermsAcceptedAsBoolean())
                            .isPrivacyPolicyAccepted(request.getIsPrivacyPolicyAcceptedAsBoolean())
                            .build();
                    User savedUser = userRepository.save(newUser);
                    return savedUser.getId();
                }
        );

        return SignUpResponse.of(userId);
    }

    private void checkPoliciesAccepted(Map<String, Boolean> policiesValueMap) {
        if (policiesValueMap.containsValue(false)) throw new RestApiException(AuthErrorCode.POLICY_NOT_ACCEPTED);
    }
}
