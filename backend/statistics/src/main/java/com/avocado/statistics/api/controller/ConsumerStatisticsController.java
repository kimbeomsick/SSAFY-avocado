package com.avocado.statistics.api.controller;

import com.avocado.statistics.api.response.BaseResp;
import com.avocado.statistics.api.service.ConsumerRecommendService;
import com.avocado.statistics.api.service.ConsumerStatisticsService;
import com.avocado.statistics.api.service.ProviderDBService;
import com.avocado.statistics.common.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ConsumerStatisticsController {
    private final ConsumerStatisticsService consumerStatisticsService;
    private final ConsumerRecommendService consumerRecommendService;
    private final ProviderDBService providerDBService;
    private final JwtUtils jwtUtils;

    @GetMapping("/merchandises/{merchandiseId}")
    public ResponseEntity<?> getStatisticsOfMerchandiseDetail(@PathVariable long merchandiseId) {
        return ResponseEntity.ok(BaseResp.of(merchandiseId+"번 상품 통계 조회 성공", consumerStatisticsService.getDetailStatistics(merchandiseId)));
    }

    @GetMapping("/recommend")
    public ResponseEntity<?> getRecommendation(HttpServletRequest request) {
        Claims claims = jwtUtils.getClaims(request);
        return ResponseEntity.ok(BaseResp.of("구매자 추천 데이터 조회 성공", consumerRecommendService.getConsumerRecommend(claims)));
    }

    @GetMapping("/db-update")
    public ResponseEntity<?> scoreUpdate() {
        Map<String, Object> resMap = new HashMap<>();
        providerDBService.update();
        resMap.put("msg", "점수 업데이트 완료");
        return ResponseEntity.ok(resMap);
    }
}