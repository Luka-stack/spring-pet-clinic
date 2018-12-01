package com.nisshoku.springpetsclinic.repositories;

import com.nisshoku.springpetsclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
