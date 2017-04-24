
package com.solidarize.service;



import com.solidarize.model.Institution;
import com.solidarize.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class InstitutionService {
    private InstitutionRepository institutionRepository;
    
    @Autowired
    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }
    
     public Institution getInstitutionById(Integer id) {
        return institutionRepository.findInstitutionById(id);
    }

    public Institution createInstitution(Institution institution) {
        return institutionRepository.save(institution);
    }
    
    public Iterable<Institution> readInstitutions(){
      return institutionRepository.findAll();
    }
    
    public boolean deleteInstitution(Institution institution){
        try{
           institutionRepository.delete(institution);
           return true;
        }catch(Exception Ex){
           return false; 
        }
    }
    
    public Institution findInstitution(Institution institution){
        return institutionRepository.findOne(institution.getId());
    }        
    
}
