package com.learningclinic.domain.proposal.entity;

public enum ProposalStatus {
    DRAFT,              // 작성 중
    SENT,               // 멘티에게 전송됨
    ACCEPTED,           // 수락됨
    REJECTED,           // 거절됨
    REVISION_REQUESTED, // 수정 요청됨
    ON_HOLD             // 보류
}
