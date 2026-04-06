package com.learningclinic.domain.referral.entity;

public enum ReferralStatus {
    PENDING,              // 의뢰 생성됨, 멘티 자가진단 대기
    MENTEE_SUBMITTED,     // 멘티 자가진단 완료
    MENTOR_ASSIGNED,      // 멘토 배정됨
    CHECKUP_IN_PROGRESS,  // 건강검진 작성 중
    CHECKUP_COMPLETED,    // 건강검진 완료
    PROPOSAL_SENT,        // 제안서 전송됨
    PROPOSAL_ACCEPTED,    // 제안 수락됨
    PROPOSAL_REJECTED,    // 제안 거절됨
    REVISION_REQUESTED,   // 수정 요청됨
    MENTORING_ACTIVE,     // 멘토링 진행 중
    MENTORING_COMPLETED,  // 멘토링 완료
    CANCELLED             // 취소됨
}
