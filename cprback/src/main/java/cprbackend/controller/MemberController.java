package cprbackend.controller;

import cprbackend.dto.MemberDTO;
import cprbackend.dto.ResponseDTO;
import cprbackend.entity.Member;
import cprbackend.security.TokenProvider;
import cprbackend.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private TokenProvider tokenProvider;


    @PostMapping("/signup") //회원가입: 멤버 저장
    public ResponseEntity<?> register(@RequestBody MemberDTO memberDTO){
        try {
            Member member=Member.builder().userId(memberDTO.getUserId()).password(memberDTO.getPassword()).build();
            Member registeredMember=memberService.join(member);
            MemberDTO dto=MemberDTO.builder().userId(registeredMember.getUserId()).build();
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            ResponseDTO responseDTO=ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @PostMapping("/signin")  //로그인: id, pwd 가 db에 존재하는지 확인, 존재한다면 id로 토큰 발행해 dto로 전송
    public ResponseEntity<?> authenticate(@RequestBody MemberDTO memberDTO){

            Member member=Member.builder().userId(memberDTO.getUserId()).password(memberDTO.getPassword()).build();
            Member authMember =memberService.getCredentials(member.getUserId(), member.getPassword());
            if(authMember!=null){
                final String token= tokenProvider.create(authMember);
                MemberDTO dto=MemberDTO.builder().userId(authMember.getUserId()).token(token).build();
                return ResponseEntity.ok().body(dto);
            }else{
                ResponseDTO responseDTO=ResponseDTO.builder().error("Login failed").build();
                return ResponseEntity.badRequest().body(responseDTO);
            }
    }

}
