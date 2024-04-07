package com.victor.ably.wishlist.vo;

import com.victor.ably.util.PagingInfo;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WishListConditionVO {

    private String memberEmail;
    private String wishlistName;

    private int startRow;
    private int endRow;
    private int pagingWindowSize;

    public static WishListConditionVO of(String memberEmail, String wishlistName){
        return WishListConditionVO.builder()
                .memberEmail(memberEmail)
                .wishlistName(wishlistName)
                .build();
    }

    public static WishListConditionVO ofList(String memberEmail) {
        return WishListConditionVO.builder()
                .memberEmail(memberEmail)
                .build();
    }

    public static WishListConditionVO setPaging(WishListConditionVO conditionVO, PagingInfo pagingInfo) {
        return WishListConditionVO.builder()
                .memberEmail(conditionVO.getMemberEmail())
                .startRow(pagingInfo.getItemStartIndex())
                .endRow(pagingInfo.getItemEndIndex())
                .pagingWindowSize(pagingInfo.getPagingWindowSize())
                .build();
    }
}
