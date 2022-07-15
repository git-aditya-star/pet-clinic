package aditya.springframework.petclinic.services.map;

import aditya.springframework.petclinic.services.model.BaseEntity;

import java.util.*;

//Raw Hibernate Implementation using Map
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> { // BaseEntity for getId property and Long for Collections functions to take effect. Used Generics so that it will be used by all different types of Classes with same methods with different return type

    protected Map<Long, T> map  = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);

    }

    T save( T object){   //if no id is assigned then assign one to the object and then insert it to the map.
        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }
        else {
            throw new RuntimeException("Object cannot be null");
        }


        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){  //entrySet is needed to iterate over map. removeIf removes if condition is true and is checked with each value of map
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){
        Long nextId = null;
        try {                                      //For map is empty which is null
            nextId = Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException e){
            nextId =1L;
        }
        return nextId;
    }
}
