package com.example.sustainableFashion.domain.item.entity;

import com.example.sustainableFashion.domain.item.enums.ItemStatus;
import com.example.sustainableFashion.domain.item.enums.Size;
import com.example.sustainableFashion.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "size")
    @Enumerated(EnumType.STRING)
    private Size size;

    @Column(name = "using_date")
    private LocalDateTime usingDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    @Column(name = "hashtag")
    private String hashtag;
}