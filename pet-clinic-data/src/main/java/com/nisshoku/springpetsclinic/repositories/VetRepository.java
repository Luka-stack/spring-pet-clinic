package com.nisshoku.springpetsclinic.repositories;

import com.nisshoku.springpetsclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
