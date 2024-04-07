package com.victor.ably.wishlist.vo;

import com.victor.ably.util.PagingInfo;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WishProductConditionVO {

    private long wishlistSequence;
    private String memberEmail;
    private String productCode;

    private int startRow;
    private int endRow;
    private int pagingWindowSize;


    public static WishProductConditionVO of(String email, String productCode){
        return WishProductConditionVO.builder()
                .memberEmail(email)
                .productCode(productCode)
                .build();
    }

    public static WishProductConditionVO ofList(String email, long wishlistSequence){
        return WishProductConditionVO.builder()
                .memberEmail(email)
                .wishlistSequence(wishlistSequence)
                .build();
    }

    public static WishProductConditionVO setPaging(WishProductConditionVO conditionVO, PagingInfo pagingInfo) {
        return WishProductConditionVO.builder()
                .wishlistSequence(conditionVO.getWishlistSequence())
                .startRow(pagingInfo.getItemStartIndex())
                .endRow(pagingInfo.getItemEndIndex())
                .pagingWindowSize(pagingInfo.getPagingWindowSize())
                .build();
    }
}
