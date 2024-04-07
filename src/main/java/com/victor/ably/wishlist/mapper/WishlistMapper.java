package com.victor.ably.wishlist.mapper;

import com.victor.ably.wishlist.dto.WishListDTO;
import com.victor.ably.wishlist.dto.WishProductDTO;
import com.victor.ably.wishlist.vo.WishProductResultVO;
import com.victor.ably.wishlist.vo.WishlistResultVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WishlistMapper {

    WishlistMapper INSTANCE = Mappers.getMapper(WishlistMapper.class);

    @Mappings({
            @Mapping(source = "wishlistName", target = "wishlistName"),
            @Mapping(source = "listImagePath", target = "listImagePath"),
            @Mapping(source = "registerDate", target = "registerDate"),
    })
    WishListDTO wishListResultVOToWishListDTO(WishlistResultVO wishlistResultVO);
    List<WishListDTO> toWishListDTO(List<WishlistResultVO> wishlistResultVOList);
}
