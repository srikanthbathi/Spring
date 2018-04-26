package com.bathi.controllers;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.fail;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import javax.inject.Inject;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Any;
import org.springframework.http.MediaType;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.bathi.ContextInitializer;
import com.bathi.payloads.Advertisements;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextInitializer.class})
@WebAppConfiguration
public class AdvertisementTest {
	
	@Inject
	WebApplicationContext context;
	
	private MockMvc mockmvc;
	
	@Before
	public void setUp() throws Exception{
		mockmvc = MockMvcBuilders.webAppContextSetup(context).build();
		
	}
	
	private MockHttpServletRequestBuilder buildpostRequest(String title) throws JsonProcessingException{
		Advertisements add = new Advertisements();
		add.setTitle(title);
		return org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post("/hello")
		        .content(new ObjectMapper().writeValueAsString(add)).
		        contentType(APPLICATION_JSON_UTF8);
	}
	
	@Test
	public void createAdd() throws JsonProcessingException, Exception{
		mockmvc.perform(buildpostRequest("title")).
		 andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.status().is2xxSuccessful())
		.andExpect(header().string("lovca", is(not(""))))
        .andExpect(content().contentType(APPLICATION_JSON_UTF8));
	}
	
	
	
}
