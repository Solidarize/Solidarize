package com.solidarize.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solidarize.model.Tag;
import com.solidarize.repository.TagRepository;

@Service
public class TagService {
	private TagRepository tagRepository;
	
	@Autowired
	public TagService(TagRepository tagRepository){
		this.tagRepository = tagRepository;
	}
	
    public Tag getTagById(BigInteger id) {
        return tagRepository.findById(id);
    }
    
    public List<Tag> getTagByIdentifier(Integer identifier){
    	return tagRepository.findByIdentifier(identifier);
    }
	
	public List<Tag> getTagByTagname(String tagname){
		return tagRepository.findByTagname(tagname);
	}
	
	public Tag saveTag(Tag tag){
		return tagRepository.save(tag);
	}
	
	public void deleteTag(Tag tag){
		tagRepository.delete(tag);
	}
	
	public List<Tag> allTags(){
		return (List<Tag>) tagRepository.findAll();
	}
		
}
