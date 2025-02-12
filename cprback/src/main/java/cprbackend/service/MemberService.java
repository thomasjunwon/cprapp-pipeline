package cprbackend.service;

import cprbackend.entity.Member;
import cprbackend.repository.MemberRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor

public class MemberService {
    private final MemberRepository memberRepository;

    public Member join(Member member){
        return memberRepository.save(member);
    }
    public Member getCredentials(String userId,String password){
        return memberRepository.findByUserIdAndPassword(userId, password);
    }

}
