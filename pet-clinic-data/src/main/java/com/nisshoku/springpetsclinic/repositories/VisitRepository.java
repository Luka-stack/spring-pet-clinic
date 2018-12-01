package com.nisshoku.springpetsclinic.repositories;

import com.nisshoku.springpetsclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
