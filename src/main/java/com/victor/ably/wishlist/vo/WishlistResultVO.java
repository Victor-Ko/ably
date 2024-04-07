package com.victor.ably.wishlist.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class WishlistResultVO {

    private String wishlistName;
    private String listImagePath;
    private String registerDate;
}
