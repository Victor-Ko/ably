package com.victor.ably.member.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
public class MemberJoinRequestDTO extends MemberRequestDTO{

    @NotBlank
    private String name;
    private String birth;
    private String gender;
}
