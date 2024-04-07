package com.victor.ably.member;

import com.victor.ably.member.dto.request.MemberJoinRequestDTO;
import com.victor.ably.member.dto.response.MemberResponseDTO;
import com.victor.ably.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTests {

    @Autowired
    private MemberService memberService;

    @Test
    public void createMember() {
        MemberJoinRequestDTO memberJoinRequestDTO = new MemberJoinRequestDTO();
        MemberResponseDTO responseDTO = new MemberResponseDTO();
        memberJoinRequestDTO.setEmail("aaaa");
        memberService.createMember(memberJoinRequestDTO,responseDTO);
    }
}
