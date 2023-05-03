package com.avocado.product.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PageResp {
    private final Object content;
    private final Boolean is_last_page;
    private final Long last_id;
    private final LocalDateTime last_time;

    public static PageResp of(Object content, Boolean is_last_page, Long last_id, LocalDateTime last_time) {
        return PageResp.builder()
                .content(content)
                .is_last_page(is_last_page)
                .last_id(last_id)
                .last_time(last_time)
                .build();
    }

    @Builder
    private PageResp(Object content, Boolean is_last_page, Long last_id, LocalDateTime last_time) {
        this.content = content;
        this.is_last_page = is_last_page;
        this.last_id = last_id;
        this.last_time = last_time;
    }
}
