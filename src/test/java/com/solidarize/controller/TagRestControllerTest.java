package com.solidarize.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.hateoas.Resource;

import com.solidarize.service.TagService;
import com.solidarize.controller.TagRestController;
import com.solidarize.model.Tag;



@RunWith(MockitoJUnitRunner.class)
public class TagRestControllerTest {

	@Mock
	private TagService service;
	private TagRestController restController; 
	
    @Before
    public void setUp() throws Exception {
        restController = new TagRestController(service);
    }
    
    @Test
    public void shouldBeAbeToGetTagById() throws Exception {
    	BigInteger id = new BigInteger("1");
        Tag tag = new Tag(2,"Animais");
        when(service.getTagById(eq(id))).thenReturn(tag);
        Tag response = restController.getTagById(id);
        assertEquals(tag, response);
    }
    
    @Test
    public void shouldBeAbeToGetTagByIdentifier() throws Exception {
    	Integer id = 1;
    	List<Tag> tag = Arrays.asList(new Tag(2,"Animais"));
        when(service.getTagByIdentifier(eq(id))).thenReturn(tag);
        List<Tag> response =  (List<Tag>) restController.searchTagIdentifier(id);
        assertEquals(tag, response);
    }
    
    @Test
    public void shouldBeAbeToGetTagByTagname() throws Exception {
    	String tagname = "Animais";
    	List<Tag> tag = Arrays.asList(new Tag(2,"Animais"));
        when(service.getTagByTagname(eq(tagname))).thenReturn(tag);
        List<Tag> response = (List<Tag>) restController.searchByTagname(tagname);
        assertEquals(tag, response);
    }
    
    @Test
    public void shouldBeAbleToCreateTag() throws Exception{
        Tag tag = new Tag(2,"Animais");
        when(service.saveTag(eq(tag))).thenReturn(tag);
        Resource<Tag> resource = restController.createTag(tag);
        assertEquals(tag,resource.getContent());    
    }
    
    @Test
    public void shouldBeAbleToUpdateTag() throws Exception{
        Tag tag = new Tag(2,"Animais");
        when(service.saveTag(eq(tag))).thenReturn(tag);
        Resource<Tag> resource = restController.updateTag(tag);
        assertEquals(tag,resource.getContent());
    }
    
    @Test
    public void shouldBeAbleToGetTags() throws Exception{
    	List<Tag> tag = Arrays.asList(new Tag(2,"Animais"));
        when(service.allTags()).thenReturn(tag);
        List<Tag> response = (List<Tag>) restController.getTags();
        assertEquals(tag, response);
    }
}
