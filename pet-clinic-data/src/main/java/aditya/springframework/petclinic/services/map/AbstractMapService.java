package aditya.springframework.petclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//Raw Hibernate Implementation using Map
public abstract class AbstractMapService<T, ID> {

    protected Map<ID, T> map  = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);

    }

    T save(ID id, T object){
        map.put(id, object);

        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){  //entrySet is needed to iterate over map. removeIf removes if condition is true and is checked with each value of map
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
}
