package com.solidarize.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.hateoas.Resource;

import com.solidarize.model.Event;
import com.solidarize.model.Institution;
import com.solidarize.service.InstitutionService;

@RunWith(MockitoJUnitRunner.class)
public class InstitutionRestControllerTest {

	@Mock
	private InstitutionService service;
	private InstitutionRestController restController;
	
	@Before
	public void setUp() throws Exception{
		restController = new InstitutionRestController(service);
	}
	
	@Test
	public void shouldGetInstitutionById() throws Exception{
		Institution institution = new Institution("Instituição Teste", "06514185000139", "Rua Aleatória, Nº 5", "Instituição para teste", "ASKDJASLDKAJSD");
		Integer id = 1;
		
		when(service.findInstitutionById(id)).thenReturn(institution);
		
		Institution response = restController.getInstitutionById(id);
		
		assertEquals(institution, response);		
	}
	
	@Test public void shouldSaveNewInstitution() throws Exception{
		Institution institution = new Institution("Instituição Teste", "06514185000139", "Rua Aleatória, Nº 5", "Instituição para teste", "ASKDJASLDKAJSD");
		Institution institutionSaved = new Institution("Instituição Teste", "06514185000139", "Rua Aleatória, Nº 5", "Instituição para teste", "ASKDJASLDKAJSD");
		institutionSaved.setId(1);
		
		when(service.saveInstitution(eq(institution))).thenReturn(institutionSaved);
		
		Resource<Institution> response = restController.saveInstitution(institution);
		assertEquals(institutionSaved, response.getContent());
	}
	
}
