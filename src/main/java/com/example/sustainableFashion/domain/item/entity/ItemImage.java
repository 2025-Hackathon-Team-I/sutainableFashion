package com.example.sustainableFashion.domain.item.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item_image")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "image_url")
    private String imageUrl;
}