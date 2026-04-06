package com.learningclinic.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "mentor_profiles")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class MentorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id", nullable = false)
    private User mentor;

    @Column(columnDefinition = "TEXT")
    private String bio;  // 소개

    @Column(columnDefinition = "TEXT")
    private String expertise;  // 전문 분야

    @Column(columnDefinition = "TEXT")
    private String helpfulFor;  // 잘 돕는 유형

    @Column(columnDefinition = "TEXT")
    private String philosophy;  // 멘토링 철학

    @Column
    private String feedbackStyle;  // 피드백 스타일

    @Column
    private String sessionStyle;  // 진행 방식

    @Column
    private String communicationStyle;  // 선호 커뮤니케이션 방식

    @Column(columnDefinition = "TEXT")
    private String styleTags;  // 스타일 태그 (JSON)

    @Column
    private String introVideoUrl;  // 소개 영상 URL

    @Column(nullable = false)
    @Builder.Default
    private boolean profileCompleted = false;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public void completeProfile() {
        this.profileCompleted = true;
    }
}
