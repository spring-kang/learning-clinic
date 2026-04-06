package com.learningclinic.domain.checkup.entity;

import com.learningclinic.domain.referral.entity.ReferralCase;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "checkup_reports")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class CheckupReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id", nullable = false)
    private ReferralCase referralCase;

    @Column(columnDefinition = "TEXT")
    private String aiDraft;  // AI 생성 초안

    @Column(columnDefinition = "TEXT")
    private String mentorFinal;  // 멘토 최종 확정본

    @Column(columnDefinition = "TEXT")
    private String summary;  // 현재 상태 요약

    @Column(columnDefinition = "TEXT")
    private String strengths;  // 강점

    @Column(columnDefinition = "TEXT")
    private String risks;  // 위험 신호

    @Column(columnDefinition = "TEXT")
    private String capabilityScores;  // 역량 축별 평가 (JSON)

    @Column(columnDefinition = "TEXT")
    private String discrepancyNotes;  // 기관 관찰 vs 자기인식 차이

    @Column(columnDefinition = "TEXT")
    private String recommendedActions;  // 권장 개입 포인트

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private CheckupStatus status = CheckupStatus.DRAFT;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public void confirmByMentor(String mentorFinal) {
        this.mentorFinal = mentorFinal;
        this.status = CheckupStatus.CONFIRMED;
    }

    public void publish() {
        this.status = CheckupStatus.PUBLISHED;
    }
}
