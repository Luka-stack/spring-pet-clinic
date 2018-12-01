package com.nisshoku.springpetsclinic.bootstrap;

import com.nisshoku.springpetsclinic.model.*;
import com.nisshoku.springpetsclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery =  specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

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

        Visit catVisit = new Visit();
        catVisit.setPet(momosPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ryuu");
        vet1.setLastName("Tashii");
        vet1.getSpeciality().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Misaki");
        vet2.setLastName("Sakura");
        vet2.getSpeciality().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
