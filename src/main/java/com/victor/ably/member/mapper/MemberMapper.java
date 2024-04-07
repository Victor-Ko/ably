package com.victor.ably.member.mapper;

import com.victor.ably.member.dto.MemberInfoDTO;
import com.victor.ably.member.vo.MemberInfoResultVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mappings({
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "mobile", target = "mobile"),
            @Mapping(source = "birth", target = "birth"),
    })
    MemberInfoDTO toMemberInfoDTO(MemberInfoResultVO resultVO);
}
