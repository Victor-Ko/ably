package com.victor.ably.wishlist.vo;

import com.victor.ably.util.PagingInfo;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class WishProductParamVO {

    //찜목록 시퀀스
    private long wishlistSequence;
    //찜 상품코드
    private String productCode;
    //찜 상품명
    private String productName;
    //찜 상품이미지 경로
    private String productImgPath;
    //찜 상품 가격
    private BigDecimal price;
    //이메일
    private String email;

    public static WishProductParamVO ofInsert(String email, String productCode, String productName, String productImgPath, BigDecimal price, long wishlistSequence){
        return WishProductParamVO.builder()
                .wishlistSequence(wishlistSequence)
                .productCode(productCode)
                .productName(productName)
                .productImgPath(productImgPath)
                .price(price)
                .email(email)
                .build();
    }

}
