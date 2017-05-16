package com.solidarize.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.solidarize.model.Institution;
import com.solidarize.service.InstitutionService;

@RestController
@RequestMapping("/institution")
public class InstitutionRestController {
	
	private InstitutionService institutionService;
	
	@Autowired
	public InstitutionRestController(InstitutionService institutionService){
		this.institutionService = institutionService;
	}
	
	@RequestMapping(path = "/${id}", method = GET)
	public Institution getInstitutionById(@PathVariable("id") Integer id){
		return institutionService.findInstitutionById(id);
	}
	
	@RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
	public Resource<Institution> saveInstitution(@RequestBody Institution institution){
		return new Resource<Institution>(institutionService.saveInstitution(institution));		
	}
}
