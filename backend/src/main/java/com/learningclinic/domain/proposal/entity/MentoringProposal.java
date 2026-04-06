package com.learningclinic.domain.proposal.entity;

import com.learningclinic.domain.referral.entity.ReferralCase;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "mentoring_proposals")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class MentoringProposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id", nullable = false)
    private ReferralCase referralCase;

    @Column(nullable = false)
    private String title;  // 제안 제목

    @Column(columnDefinition = "TEXT")
    private String rationale;  // 제안 이유

    @Column(columnDefinition = "TEXT")
    private String goals;  // 멘토링 목표

    @Column
    private String duration;  // 예상 기간

    @Column
    private String cadence;  // 주간 진행 방식

    @Column(columnDefinition = "TEXT")
    private String mentorSupport;  // 멘토가 제공할 지원

    @Column(columnDefinition = "TEXT")
    private String menteeCommitment;  // 멘티에게 기대하는 역할

    @Column(columnDefinition = "TEXT")
    private String firstActions;  // 첫 주 액션 아이템

    @Column(columnDefinition = "TEXT")
    private String successCriteria;  // 성공 기준

    @Column(columnDefinition = "TEXT")
    private String aiDraft;  // AI 생성 초안

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private ProposalStatus status = ProposalStatus.DRAFT;

    private LocalDateTime sentAt;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public void send() {
        this.status = ProposalStatus.SENT;
        this.sentAt = LocalDateTime.now();
    }

    public void accept() {
        this.status = ProposalStatus.ACCEPTED;
    }

    public void reject() {
        this.status = ProposalStatus.REJECTED;
    }

    public void requestRevision() {
        this.status = ProposalStatus.REVISION_REQUESTED;
    }
}
