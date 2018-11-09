package com.nisshoku.springpetsclinic.services;

import com.nisshoku.springpetsclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
