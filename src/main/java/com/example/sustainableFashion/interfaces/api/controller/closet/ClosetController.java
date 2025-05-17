package com.example.sustainableFashion.interfaces.api.controller.closet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/closets")
@Tag(name = "Closet", description = "사용자 옷장 API")
public class ClosetController {

    @Operation(summary = "회원 옷장 보기", description = "사용자의 userId로 옷장 정보를 조회합니다.")
    @GetMapping("/{userId}")
    public Map<String, Object> getCloset(@PathVariable Long userId) {
        return Map.of(
                "userId", userId,
                "nickname", "승환킴의 옷장",
                "closet", List.of(
                        Map.of(
                                "itemId", 101,
                                "imageUrl", "https://cdn.example.com/items/101.jpg",
                                "name", "아이템 이름",
                                "usingDate", "2001-01-01",
                                "size", "XL",
                                "description", "텍스트 입력란입니다 입력텍스트 입력텍스트...",
                                "tags", List.of("해시태그1", "해시태그2", "해시태그3"),
                                "status", "FOR_SALE"
                        ),
                        Map.of(
                                "itemId", 102,
                                "imageUrl", "https://cdn.example.com/items/102.jpg",
                                "name", "아이템 이름",
                                "usingDate", "2001-01-01",
                                "size", "XL",
                                "description", "텍스트 입력란입니다 입력텍스트 입력텍스트...",
                                "tags", List.of("해시태그1", "해시태그2", "해시태그3"),
                                "status", "STORED"
                        )
                )
        );
    }
}
