package ru.ssau.labs.spring.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.ssau.labs.spring.model.Book;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaBookEntityRepository implements EntityRepository<Book> {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(Book book) {
        if (book.isNew()) {
            em.persist(book);
        }
        em.merge(book);
    }

    @Override
    public Book get(Long id) {
        return em.find(Book.class, id);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return em.createNamedQuery(Book.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public List<Book> getAllSorted() {
        return em.createNamedQuery(Book.ALL_SORTED, Book.class)
                .getResultList();
    }
}