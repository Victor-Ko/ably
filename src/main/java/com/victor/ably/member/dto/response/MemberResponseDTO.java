package com.victor.ably.member.dto.response;

import com.victor.ably.member.dto.MemberInfoDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class MemberResponseDTO {

    private int resultCode;
    private String resultMessage;
    private MemberInfoDTO memberInfoDTO;
}
