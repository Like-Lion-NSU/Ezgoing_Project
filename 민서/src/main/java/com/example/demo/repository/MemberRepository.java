package com.example.demo.repository;

import com.example.demo.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Member save(Member member){
    em.persist(member);
    return member;
    }

    public Optional<Member> findOne(Long id){
return em.createQuery("select m from Member m where m.id = :id", Member.class)
        .setParameter("id",id)
        .getResultList()
        .stream().findAny();
    }

    public List<Member> findAll() {
    return em.createQuery("select m from Member m", Member.class)
        .getResultList();
    }

    public void update( String location, Date date){
    em.createQuery("update Member m set m.m_location = : location, m.m_date = :date")
            .setParameter("location",location)
            .setParameter("date",date)
            .executeUpdate();
    em.clear();
    }

    public void delete (Long id){
        em.createQuery("delete from Member m where m.id = :id")
                .setParameter("id",id)
                .executeUpdate();
        em.clear();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
