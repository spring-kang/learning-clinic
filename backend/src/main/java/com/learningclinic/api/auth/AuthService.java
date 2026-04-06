package com.learningclinic.api.auth;

import com.learningclinic.api.auth.dto.LoginRequest;
import com.learningclinic.api.auth.dto.SignUpRequest;
import com.learningclinic.api.auth.dto.TokenResponse;
import com.learningclinic.common.exception.BusinessException;
import com.learningclinic.common.exception.ErrorCode;
import com.learningclinic.domain.user.entity.User;
import com.learningclinic.domain.user.repository.UserRepository;
import com.learningclinic.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Value("${jwt.expiration}")
    private long expiration;

    @Transactional
    public TokenResponse signUp(SignUpRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BusinessException(ErrorCode.DUPLICATE_EMAIL);
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .role(request.getRole())
                .phone(request.getPhone())
                .build();

        userRepository.save(user);

        return createTokenResponse(user);
    }

    public TokenResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BusinessException(ErrorCode.INVALID_PASSWORD);
        }

        if (!user.isActive()) {
            throw new BusinessException(ErrorCode.ACCESS_DENIED, "비활성화된 계정입니다.");
        }

        return createTokenResponse(user);
    }

    private TokenResponse createTokenResponse(User user) {
        String token = jwtTokenProvider.createToken(user.getEmail(), user.getRole().name());

        return TokenResponse.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .expiresIn(expiration / 1000)
                .user(TokenResponse.UserInfo.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .name(user.getName())
                        .role(user.getRole().name())
                        .build())
                .build();
    }
}
