package com.sistemalerlivros.api.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sistemalerlivros.api.dto.AutorDTO;

@RunWith(SpringRunner.class)
@WebMvcTest(AutorController.class)
public class AutorControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void cadastrarAutorComSucesso() throws Exception {
		 mvc.perform( MockMvcRequestBuilders
			      .post("/autores")
			      .content(asJsonString(new AutorDTO("nome", )))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
	}
}
