package com.learningclinic.api.auth;

import com.learningclinic.api.auth.dto.LoginRequest;
import com.learningclinic.api.auth.dto.SignUpRequest;
import com.learningclinic.api.auth.dto.TokenResponse;
import com.learningclinic.common.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth", description = "인증 API")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "회원가입", description = "새로운 사용자를 등록합니다.")
    @PostMapping("/signup")
    public ApiResponse<TokenResponse> signUp(@Valid @RequestBody SignUpRequest request) {
        TokenResponse response = authService.signUp(request);
        return ApiResponse.success(response, "회원가입이 완료되었습니다.");
    }

    @Operation(summary = "로그인", description = "이메일과 비밀번호로 로그인합니다.")
    @PostMapping("/login")
    public ApiResponse<TokenResponse> login(@Valid @RequestBody LoginRequest request) {
        TokenResponse response = authService.login(request);
        return ApiResponse.success(response, "로그인에 성공했습니다.");
    }
}
