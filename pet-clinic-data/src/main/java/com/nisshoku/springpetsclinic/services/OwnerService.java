package com.nisshoku.springpetsclinic.services;

import com.nisshoku.springpetsclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
