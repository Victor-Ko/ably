package com.victor.ably.wishlist.mapper;

import com.victor.ably.wishlist.dto.WishProductDTO;
import com.victor.ably.wishlist.vo.WishProductResultVO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WishProductMapper {
    WishProductMapper INSTANCE = Mappers.getMapper(WishProductMapper.class);

    WishProductDTO wishProductResultVOToWishProductDTO(WishProductResultVO wishProductResultVO);
    List<WishProductDTO> toWishProductDTO(List<WishProductResultVO> wishProductResultVOList);
}
