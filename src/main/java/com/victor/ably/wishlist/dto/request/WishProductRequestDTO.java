package com.victor.ably.wishlist.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Getter
public class WishProductRequestDTO {

    //찜목록 아이디
    @NotNull
    private Long wishlistSequence;
    //찜 상품코드
    @NotNull
    private String productCode;
    //찜 상품명
    private String productName;
    //찜 상품이미지 경로
    private String productImgPath;
}
