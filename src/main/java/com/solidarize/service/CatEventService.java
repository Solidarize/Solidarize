
package com.solidarize.service;


import com.solidarize.model.CatEvent;
import com.solidarize.repository.CatEventRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class CatEventService {
 private CatEventRepository cateventRepository;
    
    @Autowired
    public CatEventService(CatEventRepository cateventRepository) {
        this.cateventRepository = cateventRepository;
    }
    
    public CatEvent createCatEvent(CatEvent catevent) {
        return cateventRepository.save(catevent);
    }
    
    public Iterable<CatEvent> readCatEvents(){
      return cateventRepository.findAll();
    }
    
    public boolean deleteCatEvent(CatEvent category){
        try{
           cateventRepository.delete(category);
           return true;
        }catch(Exception Ex){
           return false; 
        }
    }
    
    public CatEvent findCatEvent(CatEvent catevent){
        List<CatEvent> listCatEvent = new ArrayList<CatEvent>();
        listCatEvent =  (List<CatEvent>) this.readCatEvents();
        for (CatEvent CE : listCatEvent){
            if (CE.equals(catevent)){
                return CE;
            }
        }
        return null;       
    }
}
