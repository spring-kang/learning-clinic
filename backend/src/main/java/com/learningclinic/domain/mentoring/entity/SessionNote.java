package com.learningclinic.domain.mentoring.entity;

import com.learningclinic.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "session_notes")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class SessionNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workspace_id", nullable = false)
    private MentoringWorkspace workspace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id", nullable = false)
    private User mentor;

    @Column(nullable = false)
    private LocalDate sessionDate;

    @Column(columnDefinition = "TEXT")
    private String summary;  // 세션 요약

    @Column(columnDefinition = "TEXT")
    private String discussion;  // 주요 논의 내용

    @Column(columnDefinition = "TEXT")
    private String nextAction;  // 다음 액션

    @Column(columnDefinition = "TEXT")
    private String menteeVisible;  // 멘티에게 공개할 내용

    @Column(columnDefinition = "TEXT")
    private String mentorPrivate;  // 멘토 전용 메모

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
