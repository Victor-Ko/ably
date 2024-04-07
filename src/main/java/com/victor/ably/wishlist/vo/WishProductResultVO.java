package com.victor.ably.wishlist.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class WishProductResultVO {

    private long wishlistSequence;
    private String productCode;
    private String productName;
    private String productImgPath;
    private String registerDate;
}
