package com.victor.ably.member.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MemberJoinRequestDTO extends MemberRequestDTO{

    private String email;
    private String password;
    private String name;
    private String birth;
    private String gender;
}
