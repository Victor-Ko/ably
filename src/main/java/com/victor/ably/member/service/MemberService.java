package com.victor.ably.member.service;

import com.victor.ably.constants.CommonErrorCode;
import com.victor.ably.member.dao.MemberDao;
import com.victor.ably.member.dto.request.MemberJoinRequestDTO;
import com.victor.ably.member.dto.request.MemberRequestDTO;
import com.victor.ably.member.dto.response.MemberResponseDTO;
import com.victor.ably.member.mapper.MemberMapper;
import com.victor.ably.member.vo.MemberInfoConditionVO;
import com.victor.ably.member.vo.MemberInfoResultVO;
import com.victor.ably.member.vo.MemberParamVO;
import com.victor.ably.util.ApiException;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDao memberDao;

    public void createMember(MemberJoinRequestDTO requestDTO, MemberResponseDTO responseDTO){
        boolean isSuccess = false;


        MemberParamVO memberParamVO = MemberParamVO.ofInsert(requestDTO.getEmail(), requestDTO.getPassword(),
                requestDTO.getName(), requestDTO.getBirth(), requestDTO.getGender());
        //중복여부 확인
        int checkDuplication = memberDao.checkMemberEmailDuplication(memberParamVO.getEmail());
        if(checkDuplication == 0){
            isSuccess = memberDao.insertMemberJoinInfo(memberParamVO) > 0 ? true : false;
        }else{
            isSuccess = false;
        }
        responseDTO.setResultCode(isSuccess == true ? 1 : 0);
        responseDTO.setResultMessage(isSuccess == true ? "성공" : "실패");
    }

    public void getMemberLogin(MemberRequestDTO requestDTO, MemberResponseDTO responseDTO) {
        // 기존 세션 삭제
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        session.invalidate();
        //회원정보 조회
        MemberInfoConditionVO memberInfoConditionVO = MemberInfoConditionVO.ofLogin(requestDTO.getEmail(), requestDTO.getPassword());
        MemberInfoResultVO memberInfoVO =  memberDao.selectMemberInfo(memberInfoConditionVO);
        memberDao.insertLoginHistory(memberInfoConditionVO);
        session.setAttribute("email", memberInfoVO.getEmail());
        session.setAttribute("name", memberInfoVO.getName());
        responseDTO.setResultCode(1);
        responseDTO.setResultMessage("로그인 성공");
    }

    public void getLoginInfo(MemberResponseDTO responseDTO) {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        if(session == null){
            throw new ApiException(CommonErrorCode.EMPTY_SESSION);
        }else{
            MemberInfoResultVO memberInfoResultVO =  memberDao.selectMemberInfo(MemberInfoConditionVO.ofInfo(session.getAttribute("email").toString()));
            if(!ObjectUtils.isEmpty(memberInfoResultVO)){
                responseDTO.setMemberInfoDTO(MemberMapper.INSTANCE.toMemberInfoDTO(memberInfoResultVO));
                responseDTO.setResultCode(1);
                responseDTO.setResultMessage("로그인 성공");
            }else{
                responseDTO.setMemberInfoDTO(null);
                responseDTO.setResultCode(0);
                responseDTO.setResultMessage("회원정보 없음");
            }
        }
    }

    public String getSessionMemberEmail() {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        if (session != null) {
            String memberEmail = session.getAttribute("email").toString();
            if (StringUtils.isNotBlank(memberEmail)) {
                MemberInfoConditionVO memberInfoConditionVO = MemberInfoConditionVO.ofInfo(memberEmail);
                return ObjectUtils.isEmpty(memberDao.selectMemberInfo(memberInfoConditionVO) ) ? StringUtils.EMPTY : memberEmail;
            }
        }
        return StringUtils.EMPTY;
    }
}
