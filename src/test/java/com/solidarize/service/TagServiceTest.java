package com.solidarize.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.solidarize.model.Tag;
import com.solidarize.repository.TagRepository;


@RunWith(MockitoJUnitRunner.class)
public class TagServiceTest {
	
	@Mock
	private TagRepository repository;
	private TagService service;
	
	@Before
    public void setUp() throws Exception {
        service = new TagService(repository);
    }

    @Test
    public void shouldBeAbleToFindTagByID() throws Exception {
    	BigInteger id = BigInteger.ONE;
        Tag tag = new Tag(2,"Animais");
        when(repository.findById(eq(id))).thenReturn(tag);
        Tag response = service.getTagById(id);
        assertEquals(tag, response);
    }
    
    @Test
    public void shouldBeAbeToTagsByIdentifier() throws Exception {
        List<Tag> tags = Arrays.asList(new Tag(2,"Animais"));
        when(repository.findAll()).thenReturn(tags);
        List<Tag> response = service.getTagByIdentifier(2);
        assertEquals(tags, response);
    }
    
    @Test
    public void shouldBeAbeToTagsByTagname() throws Exception {
        List<Tag> tags = Arrays.asList(new Tag(2,"Animais"));
        when(repository.findAll()).thenReturn(tags);
        List<Tag> response = service.getTagByTagname("Animais");
        assertEquals(tags, response);
    }
    
    @Test
    public void shouldBeAbleToSaveTag() throws Exception {
        Tag tag = new Tag(2,"Animais");
        when(repository.save(eq(tag))).thenReturn(tag);
        Tag response = service.saveTag(tag);
        assertEquals(tag, response);
    }

    @Test
    public void shouldBeAbleToDeleteTag() throws Exception {
    	BigInteger id = BigInteger.ONE;
        Tag tag = service.getTagById(id);
        service.deleteTag(tag);
        verify(repository).delete(tag);
    }
    

    @Test
    public void shouldBeAbeToAllTags() throws Exception {
        List<Tag> tags = Arrays.asList(new Tag(2,"Animais"));
        when(repository.findAll()).thenReturn(tags);
        List<Tag> response = service.allTags();
        assertEquals(tags, response);
    	
    }

}


    
  