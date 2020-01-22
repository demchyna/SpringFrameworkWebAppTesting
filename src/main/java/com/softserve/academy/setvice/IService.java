package com.softserve.academy.setvice;

import java.util.List;

public interface IService<T> {
    public void create(T entity);

    public T readById(final long id);

    public void update(T entity);

    public void delete(long id);

    public List<T> readAll();
}
