package com.solidarize.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.solidarize.model.Institution;
import com.solidarize.repository.InstitutionRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InstitutionServiceTest {
	
	@Mock
	private InstitutionRepository repository;
	private InstitutionService service;
	
	@Before
	public void setUp() throws Exception {
        service = new InstitutionService(repository);
    }
	
	@Test
	public void shouldSaveNewEvent() throws Exception{
		Institution institution = new Institution("Instituição Teste", "06514185000139", "Rua Aleatória, Nº 5", "Instituição para teste", "ASKDJASLDKAJSD");
		Institution institutionSaved = new Institution("Instituição Teste", "06514185000139", "Rua Aleatória, Nº 5", "Instituição para teste", "ASKDJASLDKAJSD");
		institutionSaved.setId(1);
		
		when(repository.save(eq(institution))).thenReturn(institutionSaved);
		
		Institution response = service.saveInstitution(institution);
		assertEquals(institutionSaved, response);		
	}
	
	
	@Test 
	public void shouldGetInstitutionById() throws Exception{
		Integer id = 1;
		Institution institution = new Institution("Instituição Teste", "06514185000139", "Rua Aleatória, Nº 5", "Instituição para teste", "ASKDJASLDKAJSD");
		
		when(repository.findById(eq(id))).thenReturn(institution);
		
		Institution response = service.findInstitutionById(id);
		
		assertEquals(institution, response);
	}
	
	@Test 
	public void shouldGetInstitutionByCnpjAndCpf() throws Exception{
		String cnpj = "06514185000139";
		String password = "ASKDJASLDKAJSD";
		Institution institution = new Institution("Instituição Teste", "06514185000139", "Rua Aleatória, Nº 5", "Instituição para teste", "ASKDJASLDKAJSD");
		
		when(repository.findByCnpjAndPassword(eq(cnpj), eq(password))).thenReturn(institution);
		
		Institution response = service.login(cnpj, password);
		
		assertEquals(institution, response);
	}

}
