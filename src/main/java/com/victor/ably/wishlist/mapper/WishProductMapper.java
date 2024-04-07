package com.victor.ably.wishlist.mapper;

import com.victor.ably.wishlist.dto.WishProductDTO;
import com.victor.ably.wishlist.vo.WishProductResultVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WishProductMapper {
    WishProductMapper INSTANCE = Mappers.getMapper(WishProductMapper.class);

    @Mappings({
            @Mapping(source = "wishlistSequence", target = "wishlistSequence"),
            @Mapping(source = "productCode", target = "productCode"),
            @Mapping(source = "productName", target = "productName"),
            @Mapping(source = "productImgPath", target = "productImgPath"),
            @Mapping(source = "registerDate", target = "registerDate"),
    })
    WishProductDTO wishProductResultVOToWishProductDTO(WishProductResultVO wishProductResultVO);
    List<WishProductDTO> toWishProductDTO(List<WishProductResultVO> wishProductResultVOList);
}
