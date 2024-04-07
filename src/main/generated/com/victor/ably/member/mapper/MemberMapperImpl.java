package com.victor.ably.member.mapper;

import com.victor.ably.member.dto.MemberInfoDTO;
import com.victor.ably.member.vo.MemberInfoResultVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-07T19:36:19+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberInfoDTO toMemberInfoDTO(MemberInfoResultVO resultVO) {
        if ( resultVO == null ) {
            return null;
        }

        MemberInfoDTO memberInfoDTO = new MemberInfoDTO();

        memberInfoDTO.setEmail( resultVO.getEmail() );
        memberInfoDTO.setName( resultVO.getName() );
        memberInfoDTO.setMobile( resultVO.getMobile() );
        memberInfoDTO.setBirth( resultVO.getBirth() );

        return memberInfoDTO;
    }
}
