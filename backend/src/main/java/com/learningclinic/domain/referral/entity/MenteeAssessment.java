package com.learningclinic.domain.referral.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "mentee_assessments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class MenteeAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id", nullable = false)
    private ReferralCase referralCase;

    @Column(columnDefinition = "TEXT")
    private String goals;  // 목표

    @Column(columnDefinition = "TEXT")
    private String concerns;  // 현재 고민/어려움

    @Column
    private Integer confidenceLevel;  // 자신감 수준 (1-5)

    @Column(columnDefinition = "TEXT")
    private String habits;  // 학습 습관

    @Column(columnDefinition = "TEXT")
    private String constraints;  // 시간/환경 제약

    @Column(columnDefinition = "TEXT")
    private String preferences;  // 선호 멘토링 방식

    @Column
    private Integer feedbackIntensity;  // 원하는 피드백 강도 (1-5)

    @Column(columnDefinition = "TEXT")
    private String expectedOutcomes;  // 기대하는 결과

    @Column(nullable = false)
    @Builder.Default
    private boolean submitted = false;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public void submit() {
        this.submitted = true;
    }
}
