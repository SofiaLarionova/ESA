package ru.ssau.labs.spring.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.ssau.labs.spring.model.CvModel;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaCvModelEntityRepository implements EntityRepository<CvModel> {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(CvModel model) {
        if (model.isNew()) {
            em.persist(model);
        }
        em.merge(model);
    }

    @Override
    public CvModel get(Long id) {
        return em.find(CvModel.class, id);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return em.createNamedQuery(CvModel.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public List<CvModel> getAllSorted() {
        return em.createNamedQuery(CvModel.ALL_SORTED, CvModel.class)
                .getResultList();
    }
}