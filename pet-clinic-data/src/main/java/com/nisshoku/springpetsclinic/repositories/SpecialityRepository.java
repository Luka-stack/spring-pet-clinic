package com.nisshoku.springpetsclinic.repositories;

import com.nisshoku.springpetsclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
