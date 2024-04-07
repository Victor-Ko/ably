package com.victor.ably.wishlist.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class WishProductRequestDTO {

    //찜목록 아이디
    private long wishlistSequence;
    //찜 상품코드
    private String productCode;
    //찜 상품명
    private String productName;
    //찜 상품이미지 경로
    private String productImgPath;
}
