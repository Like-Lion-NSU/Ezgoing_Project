//package com.example.demo.repository;
//
//import com.example.demo.domain.User;
//import jakarta.persistence.EntityManager;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//@RequiredArgsConstructor
//public class MemberRepository {
//
//    private final EntityManager em;
//
//    public User save(User user){
//    em.persist(user);
//    return user;
//    }
//
//    public Optional<User> findOne(Long id){
//return em.createQuery("select m from User m where m.id = :id", User.class)
//        .setParameter("id",id)
//        .getResultList()
//        .stream().findAny();
//    }
//
//    public List<User> findAll() {
//    return em.createQuery("select m from User m", User.class)
//        .getResultList();
//    }
//
//    public void update( String location, Date date){
//    em.createQuery("update User m set m.m_location = : location, m.m_date = :date")
//            .setParameter("location",location)
//            .setParameter("date",date)
//            .executeUpdate();
//    em.clear();
//    }
//
//    public void delete (Long id){
//        em.createQuery("delete from User m where m.id = :id")
//                .setParameter("id",id)
//                .executeUpdate();
//        em.clear();
//    }
//
//    public List<User> findByName(String name) {
//        return em.createQuery("select m from User m where m.name = :name", User.class)
//                .setParameter("name", name)
//                .getResultList();
//    }
//}
