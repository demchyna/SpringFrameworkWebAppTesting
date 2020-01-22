package com.softserve.academy.repository;

import java.util.List;

public interface IRepository<T> {
    public void create(T entity);

    public T readById(final long id);

    public void update(T entity);

    public void delete(long id);

    public List<T> readAll();
}
