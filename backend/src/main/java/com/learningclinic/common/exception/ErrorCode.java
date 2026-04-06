package com.learningclinic.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // Common
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "COMMON_001", "잘못된 입력입니다."),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON_002", "리소스를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON_003", "서버 오류가 발생했습니다."),

    // Auth
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "AUTH_001", "인증이 필요합니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "AUTH_002", "유효하지 않은 토큰입니다."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "AUTH_003", "만료된 토큰입니다."),
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "AUTH_004", "접근 권한이 없습니다."),

    // User
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_001", "사용자를 찾을 수 없습니다."),
    DUPLICATE_EMAIL(HttpStatus.CONFLICT, "USER_002", "이미 사용 중인 이메일입니다."),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "USER_003", "비밀번호가 올바르지 않습니다."),

    // Referral
    REFERRAL_NOT_FOUND(HttpStatus.NOT_FOUND, "REFERRAL_001", "의뢰 케이스를 찾을 수 없습니다."),
    INVALID_REFERRAL_STATUS(HttpStatus.BAD_REQUEST, "REFERRAL_002", "잘못된 의뢰 상태입니다."),

    // Checkup
    CHECKUP_NOT_FOUND(HttpStatus.NOT_FOUND, "CHECKUP_001", "건강검진 리포트를 찾을 수 없습니다."),
    CHECKUP_ALREADY_CONFIRMED(HttpStatus.BAD_REQUEST, "CHECKUP_002", "이미 확정된 건강검진입니다."),

    // Proposal
    PROPOSAL_NOT_FOUND(HttpStatus.NOT_FOUND, "PROPOSAL_001", "제안서를 찾을 수 없습니다."),
    PROPOSAL_ALREADY_SENT(HttpStatus.BAD_REQUEST, "PROPOSAL_002", "이미 전송된 제안서입니다."),
    PROPOSAL_NOT_SENT(HttpStatus.BAD_REQUEST, "PROPOSAL_003", "아직 전송되지 않은 제안서입니다."),

    // Mentoring
    WORKSPACE_NOT_FOUND(HttpStatus.NOT_FOUND, "MENTORING_001", "워크스페이스를 찾을 수 없습니다."),
    WORKSPACE_NOT_ACTIVE(HttpStatus.BAD_REQUEST, "MENTORING_002", "활성화된 워크스페이스가 아닙니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
