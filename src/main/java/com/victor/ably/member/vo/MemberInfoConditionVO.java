package com.victor.ably.member.vo;

import lombok.Builder;
import org.apache.commons.lang3.StringUtils;

@Builder
public class MemberInfoConditionVO {

    private String email;
    private String password;

    public static MemberInfoConditionVO ofLogin(String email, String password) {
        if (StringUtils.isBlank(email)) throw new IllegalArgumentException("MemberInfoConditionVO.email Parameter Error");
        if (StringUtils.isBlank(password)) throw new IllegalArgumentException("MemberInfoConditionVO.password Parameter Error");

        return MemberInfoConditionVO.builder()
                .email(email)
                .password(password)
                .build();
    }

    public static MemberInfoConditionVO ofInfo(String email) {
        if (StringUtils.isBlank(email)) throw new IllegalArgumentException("MemberInfoConditionVO.returnUrl Parameter Error");

        return MemberInfoConditionVO.builder()
                .email(email)
                .build();
    }
}
