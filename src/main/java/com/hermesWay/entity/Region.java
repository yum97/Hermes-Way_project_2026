package com.hermesway.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 地域を表すエンティティ
 */
@Entity
@Table(name = "regions")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Region extends BaseEntity {

    // 地域ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 地域の名前
    @Column(nullable = false, length = 100)
    private String name;

    // 地域のコード
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id")
    private Country country;
}