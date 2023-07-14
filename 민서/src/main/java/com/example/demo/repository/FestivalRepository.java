package com.example.demo.repository;

import com.example.demo.domain.Festival;
import com.example.demo.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FestivalRepository {
  private final EntityManager em;

  public Festival save(Festival festival){
    em.persist(festival);
    return festival;
  }

  public List<Festival>  findFestival (Member member){
    return em.createQuery("select f from Festival f where f.fe_location = :location and f.fe_date = :date",Festival.class)
            .setParameter("Member", member)
            .getResultList()
            ;
  }

  public Optional<Festival> findOne(Long id){
    return em.createQuery("select f from Festival f where f.id = : id",Festival.class)
            .setParameter("id",id)
            .getResultList()
            .stream().findAny();
  }

  public List<Festival> findAll(){
      List<Festival> result =em.createQuery("select f from Festival f ",Festival.class)
              .getResultList();
      return result;
  }

  public List<Festival> findByName(String fe_name) {
    return em.createQuery("select f from Festival f where f.fe_name = :name", Festival.class)
            .setParameter("name", fe_name)
            .getResultList();
  }
  public void delete(Long id){
em.createQuery("delete from Festival f where f.id = :id")
        .setParameter("id",id)
        .executeUpdate();
em.clear();
  }

}
