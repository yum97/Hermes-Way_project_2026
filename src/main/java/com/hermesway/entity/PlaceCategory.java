package com.hermesway.entity;

/**
 * 場所のカテゴリを表す列挙型 Entityではなく、Enumとして定義されるため、データベースのテーブルとしては存在しない。
 */
public enum PlaceCategory {

    TOURIST_SPOT,
    RESTAURANT,
    CAFE,
    ACCOMMODATION,
    SHOPPING,
    ACTIVITY,
    OTHER
}