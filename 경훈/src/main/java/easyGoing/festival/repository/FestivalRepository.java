package easyGoing.festival.repository;

import easyGoing.festival.domain.Festival;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FestivalRepository {
    private final EntityManager em;

    public void save(Festival festival) {
        em.persist(festival);
    }

    public Festival findOne(Long id) {
        return em.find(Festival.class, id);
    }

    public List<Festival> findAll() {
        return em.createQuery("select f from Festival f", Festival.class)
                .getResultList();
    }

    public List<Festival> findByName(String fe_name) {
        return em.createQuery("select f from Festival f where f.fe_name = :name", Festival.class)
                .setParameter("name", fe_name)
                .getResultList();
    }

}
