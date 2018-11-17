package com.nisshoku.springpetsclinic.bootstrap;

import com.nisshoku.springpetsclinic.model.Owner;
import com.nisshoku.springpetsclinic.model.Vet;
import com.nisshoku.springpetsclinic.services.OwnerService;
import com.nisshoku.springpetsclinic.services.VetService;
import com.nisshoku.springpetsclinic.services.map.OwnerServiceMap;
import com.nisshoku.springpetsclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Takahiro");
        owner1.setLastName("Hayami");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Momo");
        owner2.setLastName("Hirai");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Ryuu");
        vet1.setLastName("Tashii");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Misaki");
        vet2.setLastName("Sakura");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
