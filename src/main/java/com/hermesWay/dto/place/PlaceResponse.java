package com.hermesway.dto.place;

import com.hermesway.entity.Place;
import lombok.Builder;
import lombok.Getter;

/**
 * 場所の詳細情報をクライアントへ返すレスポンスDTO
 */
@Getter
@Builder
public class PlaceResponse {

    // 場所ID
    private Long id;

    // 場所名
    private String name;

    // 場所カテゴリー
    private String category;

    // 地域ID
    private Long regionId;

    // 地域名
    private String regionName;

    // 国ID
    private Long countryId;

    // 国名
    private String countryName;

    // 国コード
    private String countryCode;

    // Google Place ID
    private String googlePlaceId;

    // 住所
    private String address;

    // 電話番号
    private String phone;

    // Webサイト
    private String website;

    // 緯度
    private Double latitude;

    // 経度
    private Double longitude;

    // Google評価
    private Double googleRating;

    // 営業時間
    private String openingHours;

    /**
     * PlaceエンティティをPlaceResponse DTOへ変換する
     */
    public static PlaceResponse from(Place place) {
        return PlaceResponse.builder()
                .id(place.getId())
                .name(place.getName())
                .category(place.getCategory().name())
                .regionId(place.getRegion().getId())
                .regionName(place.getRegion().getName())
                .countryId(place.getRegion().getCountry().getId())
                .countryName(place.getRegion().getCountry().getName())
                .countryCode(place.getRegion().getCountry().getCode())
                .googlePlaceId(place.getGooglePlaceId())
                .address(place.getAddress())
                .phone(place.getPhone())
                .website(place.getWebsite())
                .latitude(place.getLatitude())
                .longitude(place.getLongitude())
                .googleRating(place.getGoogleRating())
                .openingHours(place.getOpeningHours())
                .build();
    }
}