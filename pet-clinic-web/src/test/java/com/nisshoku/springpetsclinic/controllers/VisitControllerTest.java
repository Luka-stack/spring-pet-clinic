package com.nisshoku.springpetsclinic.controllers;

import com.nisshoku.springpetsclinic.services.PetService;
import com.nisshoku.springpetsclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

    @Mock
    PetService petService;

    @Mock
    VisitService visitService;

    @InjectMocks
    VisitController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {

    }

    @Test
    void initNewVisitForm() throws Exception {
    }
}