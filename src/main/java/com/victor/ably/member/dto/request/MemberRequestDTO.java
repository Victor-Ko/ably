package com.victor.ably.member.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberRequestDTO {
    private String email;
    private String password;
}
