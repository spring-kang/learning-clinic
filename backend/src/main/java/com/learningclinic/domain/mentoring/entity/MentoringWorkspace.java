package com.learningclinic.domain.mentoring.entity;

import com.learningclinic.domain.referral.entity.ReferralCase;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "mentoring_workspaces")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class MentoringWorkspace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id", nullable = false)
    private ReferralCase referralCase;

    @Column(nullable = false)
    private LocalDate startDate;

    private LocalDate endDate;

    @Column(columnDefinition = "TEXT")
    private String goals;  // 멘토링 목표

    @Column(columnDefinition = "TEXT")
    private String currentActions;  // 현재 진행 중인 액션

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private WorkspaceStatus status = WorkspaceStatus.ACTIVE;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public void complete() {
        this.status = WorkspaceStatus.COMPLETED;
        this.endDate = LocalDate.now();
    }

    public void pause() {
        this.status = WorkspaceStatus.PAUSED;
    }

    public void resume() {
        this.status = WorkspaceStatus.ACTIVE;
    }
}
