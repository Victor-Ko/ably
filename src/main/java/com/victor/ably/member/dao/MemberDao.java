package com.victor.ably.member.dao;

import com.victor.ably.member.dto.request.MemberRequestDTO;
import com.victor.ably.member.vo.MemberInfoConditionVO;
import com.victor.ably.member.vo.MemberInfoResultVO;
import com.victor.ably.member.vo.MemberParamVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberDao {

     int checkMemberEmailDuplication(String memberId);

    int insertMemberJoinInfo(MemberParamVO paramVO);

    MemberInfoResultVO selectMemberInfo(MemberInfoConditionVO conditionVO);

    int insertLoginHistory(MemberInfoConditionVO conditionVO);
}
