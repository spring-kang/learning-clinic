package com.learningclinic.domain.referral.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "institution_inputs")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class InstitutionInput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id", nullable = false)
    private ReferralCase referralCase;

    @Column
    private String programName;  // 과정명

    @Column
    private String attendance;  // 출석 정보

    @Column(columnDefinition = "TEXT")
    private String scores;  // 평가/점수 정보 (JSON)

    @Column(columnDefinition = "TEXT")
    private String notes;  // 담당자 코멘트

    @Column(columnDefinition = "TEXT")
    private String referralReason;  // 의뢰 목적

    @Column(columnDefinition = "TEXT")
    private String currentStatus;  // 기관이 보는 현재 상태

    @Column
    private String attachmentUrl;  // 첨부 파일 URL

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
