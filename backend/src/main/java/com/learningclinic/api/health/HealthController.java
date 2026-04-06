package com.learningclinic.api.health;

import com.learningclinic.common.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@Tag(name = "Health", description = "서버 상태 확인 API")
@RestController
@RequestMapping("/api/health")
public class HealthController {

    @Operation(summary = "서버 상태 확인", description = "서버가 정상적으로 동작 중인지 확인합니다.")
    @GetMapping
    public ApiResponse<Map<String, Object>> healthCheck() {
        return ApiResponse.success(Map.of(
                "status", "UP",
                "timestamp", LocalDateTime.now(),
                "service", "Learning-Clinic API"
        ));
    }
}
