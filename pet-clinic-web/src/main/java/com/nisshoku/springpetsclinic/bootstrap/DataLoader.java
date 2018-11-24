package com.nisshoku.springpetsclinic.bootstrap;

import com.nisshoku.springpetsclinic.model.Owner;
import com.nisshoku.springpetsclinic.model.Pet;
import com.nisshoku.springpetsclinic.model.PetType;
import com.nisshoku.springpetsclinic.model.Vet;
import com.nisshoku.springpetsclinic.services.OwnerService;
import com.nisshoku.springpetsclinic.services.PetTypeService;
import com.nisshoku.springpetsclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Takahiro");
        owner1.setLastName("Hayami");
        owner1.setAddress("123 Sakura");
        owner1.setCity("Osaka");
        owner1.setTelephone("123456789");

        Pet takasPet = new Pet();
        takasPet.setPetType(savedDogPetType);
        takasPet.setOwner(owner1);
        takasPet.setBirthDate(LocalDate.now());
        takasPet.setName("Inu");
        owner1.getPets().add(takasPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Momo");
        owner2.setLastName("Hirai");
        owner1.setAddress("123 Sakura");
        owner1.setCity("Osaka");
        owner1.setTelephone("111000222");

        Pet momosPet = new Pet();
        momosPet.setPetType(savedCatPetType);
        momosPet.setOwner(owner2);
        momosPet.setBirthDate(LocalDate.now());
        momosPet.setName("Nekko");
        owner2.getPets().add(momosPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ryuu");
        vet1.setLastName("Tashii");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Misaki");
        vet2.setLastName("Sakura");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
