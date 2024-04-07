package com.victor.ably.wishlist.mapper;

import com.victor.ably.wishlist.dto.WishProductDTO;
import com.victor.ably.wishlist.vo.WishProductResultVO;
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
public class WishProductMapperImpl implements WishProductMapper {

    @Override
    public WishProductDTO wishProductResultVOToWishProductDTO(WishProductResultVO wishProductResultVO) {
        if ( wishProductResultVO == null ) {
            return null;
        }

        WishProductDTO wishProductDTO = new WishProductDTO();

        wishProductDTO.setWishlistSequence( wishProductResultVO.getWishlistSequence() );
        wishProductDTO.setProductCode( wishProductResultVO.getProductCode() );
        wishProductDTO.setProductName( wishProductResultVO.getProductName() );
        wishProductDTO.setProductImgPath( wishProductResultVO.getProductImgPath() );
        wishProductDTO.setRegisterDate( wishProductResultVO.getRegisterDate() );

        return wishProductDTO;
    }

    @Override
    public List<WishProductDTO> toWishProductDTO(List<WishProductResultVO> wishProductResultVOList) {
        if ( wishProductResultVOList == null ) {
            return null;
        }

        List<WishProductDTO> list = new ArrayList<WishProductDTO>( wishProductResultVOList.size() );
        for ( WishProductResultVO wishProductResultVO : wishProductResultVOList ) {
            list.add( wishProductResultVOToWishProductDTO( wishProductResultVO ) );
        }

        return list;
    }
}
