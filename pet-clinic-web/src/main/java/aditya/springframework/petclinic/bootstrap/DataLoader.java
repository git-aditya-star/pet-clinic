package aditya.springframework.petclinic.bootstrap;

import aditya.springframework.petclinic.services.OwnerService;
import aditya.springframework.petclinic.services.VetService;
import aditya.springframework.petclinic.services.model.Owner;
import aditya.springframework.petclinic.services.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component  //it get registers into spring context so that it can be executed by the spring
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }



    @Override
    public void run(String... args) throws Exception { //spring runs this method
        //creating raw data as not yet connected to any database
        Owner owner1 = new Owner();

        owner1.setFirstName("Naruto");
        owner1.setLastName("Uzumaki");
        ownerService.save(owner1);  //saving the objects to the map for id

        Owner owner2 = new Owner();

        owner2.setFirstName("Minato");
        owner2.setLastName("Namikaze");
        ownerService.save(owner2);

        System.out.println("Loading Owners ---");

        Vet vet1 = new Vet();

        vet1.setFirstName("Itachi");
        vet1.setLastName("Uchiha");
        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Kakashi");
        vet2.setLastName("Hatake");
        vetService.save(vet2);

        System.out.println("Loading Vets ---");




    }
}
