package com.learningclinic.domain.checkup.entity;

import com.learningclinic.domain.referral.entity.ReferralCase;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "fit_summaries")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class FitSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id", nullable = false)
    private ReferralCase referralCase;

    @Column(columnDefinition = "TEXT")
    private String mentorStyleSummary;  // 멘토 스타일 요약

    @Column(columnDefinition = "TEXT")
    private String menteePreferenceSummary;  // 멘티 선호도 요약

    @Column(columnDefinition = "TEXT")
    private String fitPoints;  // 잘 맞는 요소

    @Column(columnDefinition = "TEXT")
    private String cautionPoints;  // 조정이 필요한 요소 / 주의 포인트

    @Column(columnDefinition = "TEXT")
    private String aiDraft;  // AI 생성 초안

    @Column(columnDefinition = "TEXT")
    private String mentorRevision;  // 멘토 수정본

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
