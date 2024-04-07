package com.victor.ably.wishlist.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class WishlistRequestDTO {

    //찜목록 아이디
    private long wishlistSequence;
    //찜목록 이름
    private String wishlistName;
    //찜목록대표이미지
    private String listImagePath;
}
