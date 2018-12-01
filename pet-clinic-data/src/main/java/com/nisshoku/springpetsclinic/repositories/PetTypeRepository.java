package com.nisshoku.springpetsclinic.repositories;

import com.nisshoku.springpetsclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
