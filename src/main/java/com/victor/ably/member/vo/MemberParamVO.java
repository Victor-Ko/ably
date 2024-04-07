package com.victor.ably.member.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberParamVO {

    private String email;
    private String password;
    private String name;
    private String birth;
    private String gender;

    public static MemberParamVO ofInsert(String email, String password, String name, String birth, String gender){
        return MemberParamVO.builder()
                .email(email)
                .password(password)
                .name(name)
                .birth(birth)
                .gender(gender)
                .build();
    }
}
