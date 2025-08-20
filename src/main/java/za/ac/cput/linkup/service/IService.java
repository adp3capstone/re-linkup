package za.ac.cput.linkup.service;

public interface IService<T, ID> {
    T read(ID id);
}
