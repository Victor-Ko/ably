package com.victor.ably.member.controller;

import com.victor.ably.constants.CommonErrorCode;
import com.victor.ably.member.dto.request.MemberJoinRequestDTO;
import com.victor.ably.member.dto.request.MemberRequestDTO;
import com.victor.ably.member.dto.response.MemberResponseDTO;
import com.victor.ably.member.service.MemberService;
import com.victor.ably.util.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/member")
public class MemberController {

    private final MemberService memberService;

    //회원가입
    @PostMapping(value = "/join")
    public ResponseEntity<?> memberJoin(@RequestBody @Validated MemberJoinRequestDTO requestDTO) {
        MemberResponseDTO responseDTO = new MemberResponseDTO();
        try {
            memberService.createMember(requestDTO, responseDTO);
        } catch (Exception exception) {
            throw new ApiException(CommonErrorCode.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //로그인
    @GetMapping(value = "/login")
    public ResponseEntity<?> memberLogin(@Validated @RequestBody MemberRequestDTO requestDTO) {
        MemberResponseDTO responseDTO = new MemberResponseDTO();
        try {
            memberService.getMemberLogin(requestDTO, responseDTO);
        } catch (Exception exception) {
            throw new ApiException(CommonErrorCode.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //내 정보
    @GetMapping(value = "/info")
    public ResponseEntity<?> loginInfo() {
        MemberResponseDTO responseDTO = new MemberResponseDTO();
        try {
            memberService.getLoginInfo(responseDTO);
        } catch (Exception exception) {
            throw exception;
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
