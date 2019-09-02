package com.sistemalerlivros.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistemalerlivros.api.ConfiguracaoTest;
import com.sistemalerlivros.api.dto.AutorDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AutorControllerTest extends ConfiguracaoTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void cadastrarAutorComSucesso() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/v1/biblioteca/autores")
                .content(mapper.writeValueAsString(new AutorDTO("nome", LocalDate.now(), null)))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idAutor").exists()).andExpect(status().isCreated());
    }


}
