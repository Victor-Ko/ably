package com.victor.ably.member.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public class MemberRequestDTO {

    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
