package com.victor.ably.wishlist.mapper;

import com.victor.ably.wishlist.dto.WishListDTO;
import com.victor.ably.wishlist.vo.WishlistResultVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-07T19:36:19+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class WishlistMapperImpl implements WishlistMapper {

    @Override
    public WishListDTO wishListResultVOToWishListDTO(WishlistResultVO wishlistResultVO) {
        if ( wishlistResultVO == null ) {
            return null;
        }

        WishListDTO wishListDTO = new WishListDTO();

        wishListDTO.setWishlistName( wishlistResultVO.getWishlistName() );
        wishListDTO.setListImagePath( wishlistResultVO.getListImagePath() );
        wishListDTO.setRegisterDate( wishlistResultVO.getRegisterDate() );

        return wishListDTO;
    }

    @Override
    public List<WishListDTO> toWishListDTO(List<WishlistResultVO> wishlistResultVOList) {
        if ( wishlistResultVOList == null ) {
            return null;
        }

        List<WishListDTO> list = new ArrayList<WishListDTO>( wishlistResultVOList.size() );
        for ( WishlistResultVO wishlistResultVO : wishlistResultVOList ) {
            list.add( wishListResultVOToWishListDTO( wishlistResultVO ) );
        }

        return list;
    }
}
