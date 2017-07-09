package com.solidarize.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.solidarize.model.Tag;
import com.solidarize.service.TagService;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class TagRestController {

	private TagService tagService;

    @Autowired
    public TagRestController(TagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping(path = "/tag/{id}", method = GET)
    public Tag getTagById(@PathVariable("id") BigInteger id) {
        return tagService.getTagById(id);        
    }


    @RequestMapping(path = "tags", method = GET)
    public List<Tag> getTags() {
        return tagService.allTags();
    }


    @RequestMapping(path = "/tag", method = POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public Resource<Tag> createTag(@RequestBody Tag tag) {
        return new Resource<>(tagService.saveTag(tag));
    }
    
    @RequestMapping(path = "/tagidentifier", method = POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public Resource<List<Tag>> searchTagIdentifier(@RequestBody Integer identifier) {
        return new Resource<>(tagService.getTagByIdentifier(identifier));
    }

    @RequestMapping(path = "/tagbytagname", method = POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public Resource<List<Tag>> searchByTagname(@RequestBody String tagname) {
        return new Resource<>(tagService.getTagByTagname(tagname));
    }
    
    
    @RequestMapping(path = "/tag", method = PUT, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public Resource<Tag> updateTag(@RequestBody Tag tag) {
        return new Resource<>(tagService.saveTag(tag));
    }

    @RequestMapping(path = "tag/{id}", method = DELETE)
    @ResponseStatus(OK)
    public void deleteTag(@PathVariable("id") BigInteger id) {
    	Tag tagdelete = tagService.getTagById(id);
        tagService.deleteTag(tagdelete);
    }

}
