package ru.ssau.labs.spring.repository;

import java.util.List;

public interface EntityRepository<E> {

    void save(E e);

    E get(Long id);

    boolean delete(Long id);

    List<E> getAllSorted();

}