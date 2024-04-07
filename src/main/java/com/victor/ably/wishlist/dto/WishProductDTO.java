package com.victor.ably.wishlist.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class WishProductDTO {

    private long wishlistSequence;
    private String productCode;
    private String productName;
    private String productImgPath;
    private String registerDate;
    private BigDecimal price;
}
