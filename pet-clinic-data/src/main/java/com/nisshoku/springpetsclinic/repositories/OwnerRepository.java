package com.nisshoku.springpetsclinic.repositories;

import com.nisshoku.springpetsclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
