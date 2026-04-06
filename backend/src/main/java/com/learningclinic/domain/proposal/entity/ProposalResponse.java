package com.learningclinic.domain.proposal.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "proposal_responses")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class ProposalResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proposal_id", nullable = false)
    private MentoringProposal proposal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MenteeDecision decision;

    @Column(columnDefinition = "TEXT")
    private String feedback;  // 멘티 코멘트/피드백

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime respondedAt;
}
