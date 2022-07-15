package aditya.springframework.petclinic.services;

import aditya.springframework.petclinic.services.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    //OwnerService has  other common methods too which are already defined in the CrudService only Unique ones are to be declared.
    Owner findByLastName(String lastName);

}
