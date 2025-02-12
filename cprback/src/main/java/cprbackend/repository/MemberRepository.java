package cprbackend.repository;

import cprbackend.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

    public Member save(Member member){
        em.persist(member);
        return member;
    }

    public Member findOne(Long id){
        return em.find(Member.class,id);
    }
    public Member findByUserId(String userId){
        return em.createQuery("select m from Member m where m.userId=:userId", Member.class).setParameter("userId",userId).getSingleResult();
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public Member findByUserIdAndPassword(String userId, String password){
        return em.createQuery("select m from Member m where m.userId=:userId and m.password=:password",Member.class).setParameter("userId",userId).setParameter("password",password).getSingleResult();
    }
}
