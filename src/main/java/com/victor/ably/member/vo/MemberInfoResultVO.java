package com.victor.ably.member.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class MemberInfoResultVO {

    private String email;
    private String name;
    private String mobile;
    private String birth;
}
