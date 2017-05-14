package com.solidarize.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solidarize.model.Institution;
import com.solidarize.repository.InstitutionRepository;

@Service
public class InstitutionService {

	private InstitutionRepository institutionRepository;

	@Autowired
	public InstitutionService(InstitutionRepository institutionRepository){
		this.institutionRepository = institutionRepository;
	}
	
	public Institution findInstitutionById(Integer id){
		return institutionRepository.findInstitutionById(id);
	}
	
	public Institution saveInstitution(Institution institution){
		return institutionRepository.save(institution);
	}
	
	public void deleteInstitution(Institution institution){
		institutionRepository.delete(institution);
	}
}
