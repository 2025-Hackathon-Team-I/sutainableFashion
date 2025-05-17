package com.domain.entity.trade;

import com.domain.entity.item.comments.ItemComments;
import com.domain.entity.trade.enums.TradeStatus;
import com.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "trade")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Trade extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private ItemComments comment;

    @CreatedDate
    @Column(name = "trade_at")
    private LocalDateTime tradeAt;

    @Column(name = "trade_status")
    @Enumerated(EnumType.STRING)
    private TradeStatus tradeStatus;

    @Column(name = "trade_place")
    private String tradePlace;

    @Column(name = "kakao_link")
    private String kakaoLink;
}
