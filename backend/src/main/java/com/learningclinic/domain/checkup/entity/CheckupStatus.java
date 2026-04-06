package com.learningclinic.domain.checkup.entity;

public enum CheckupStatus {
    DRAFT,       // AI 초안 생성됨
    CONFIRMED,   // 멘토 확정됨
    PUBLISHED    // 멘티에게 공개됨
}
