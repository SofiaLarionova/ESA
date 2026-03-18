package ru.ssau.labs.repository;

import java.util.List;

public interface Storage<E> {

    void clear();

    void save(E r);

    void update(E entity);

    E get(Integer uuid);

    void delete(Integer uuid);

    List<E> getAllSorted();

    int size();
}