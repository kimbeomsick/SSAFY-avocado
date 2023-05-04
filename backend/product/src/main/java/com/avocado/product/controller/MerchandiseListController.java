package com.avocado.product.controller;

import com.avocado.product.config.UUIDUtil;
import com.avocado.product.dto.response.BaseResp;
import com.avocado.product.dto.response.ClickMerchandiseResp;
import com.avocado.product.dto.response.PageResp;
import com.avocado.product.dto.response.SimpleMerchandiseResp;
import com.avocado.product.service.MerchandiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/merchandises")
public class MerchandiseListController {
    private final MerchandiseService merchandiseService;
    private final UUIDUtil uuidUtil;

    /**
     * 카테고리와 브랜드 이름을 기준으로 상품을 조회하고 상품 ID 내림차순 정렬
     * (페이징 + No offset 기법 적용)
     * @param store : 브랜드 이름 (e.g. Nike, Puma, ...)
     * @param category : 카테고리 ID
     * @param last : 마지막으로 조회한 상품 ID
     * @param size : 한 번 요청에서 조회할 데이터 개수
     * @return : 조회 데이터, 마지막 페이지 여부, 마지막 상품 ID
     */
    @GetMapping("")
    public ResponseEntity<BaseResp> showMerchandises_NoOffset(@RequestParam @Nullable String store,
                                                     @RequestParam @Nullable Short category,
                                                     @RequestParam @Nullable Long last,
                                                     @RequestParam(defaultValue = "12") Integer size) {
        PageResp result = merchandiseService.showMerchandiseList_NoOffset(category, store, last, size);
        return ResponseEntity.ok(BaseResp.of("상품 조회 성공", result));
    }

    /**
     * 최근 본 상품을 조회하는 기능
     * @param user_id : 요청한 사용자 (로그인 구현 시 삭제 예정)
     * @return : 해당 사용자가 조회한 상품 목록
     */
    @GetMapping("/recents")
    public ResponseEntity<BaseResp> showRecentMerchandises(@RequestParam String user_id) {
        UUID consumerId = uuidUtil.joinByHyphen(user_id);
        List<ClickMerchandiseResp> result = merchandiseService.showRecentMerchandises(consumerId);
        return ResponseEntity.ok(BaseResp.of("최근 본 상품 조회 성공", result));
    }

    // 위와 동일. Offset 사용 버전
//    @GetMapping("/offset")
//    public ResponseEntity<BaseResp> showMerchandises_Offset(@RequestParam @Nullable String store,
//                                                            @RequestParam @Nullable Short category,
//                                                            @RequestParam(defaultValue = "0") Integer page,
//                                                            @RequestParam(defaultValue = "12") Integer size) {
//        PageResp result = merchandiseService.showMerchandiseList_Offset(category, store, page, size);
//        return ResponseEntity.ok(BaseResp.of("상품 조회 성공", result));
//    }
}
