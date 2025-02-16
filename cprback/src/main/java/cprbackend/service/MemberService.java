package cprbackend.service;

import cprbackend.entity.Member;
import cprbackend.repository.MemberRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Transactional
    public Member join(Member member){
        return memberRepository.save(member);
    }
    @Transactional
    public Member getCredentials(String userId,String password){
        return memberRepository.findByUserIdAndPassword(userId, password);
    }

}
