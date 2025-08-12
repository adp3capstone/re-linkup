package za.ac.cput.linkup.service;

public interface IService<T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
