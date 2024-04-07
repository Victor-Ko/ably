package com.victor.ably.wishlist.dto.response;

import com.victor.ably.util.PagingInfo;
import com.victor.ably.wishlist.dto.WishListDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
public class WishlistResponseDTO {
    private int resultCode;
    private String resultMessage;
    private PagingInfo pagingInfo = PagingInfo.builder().build();
    private List<WishListDTO> wishListDTO;
}
