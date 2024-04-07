package com.victor.ably.wishlist.vo;

import com.victor.ably.util.PagingInfo;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WishListParamVO {

    private String memberEmail;
    private String listImagePath;
    private String wishlistName;

    public static WishListParamVO of(String memberEmail, String listImagePath, String wishlistName){
        return WishListParamVO.builder()
                .memberEmail(memberEmail)
                .listImagePath(listImagePath)
                .wishlistName(wishlistName)
                .build();
    }

}
