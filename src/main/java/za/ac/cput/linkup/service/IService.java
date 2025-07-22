package za.ac.cput.linkup.service;

import java.util.List;

public interface IService<T,ID> {

    T create(T t);

    T read(ID id);

    T update(T t);
    void delete(ID id);
    List<T> findAll();

}