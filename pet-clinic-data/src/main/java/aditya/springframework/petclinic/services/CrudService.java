package aditya.springframework.petclinic.services;

import java.util.Set;
//crud service mimics the spring repository
public interface CrudService<T, ID> { // declared interface used generics and common methods which would be used so they are not repeated in other interfaces

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
