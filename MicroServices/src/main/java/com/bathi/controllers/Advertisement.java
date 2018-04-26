package com.bathi.controllers;

import java.util.HashMap;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bathi.payloads.Advertisements;

@RestController
@RequestMapping("/hello")
@Validated
public class Advertisement {

	private HashMap<Integer, Advertisements> adds = new HashMap<Integer, Advertisements>();
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<Integer, Advertisements> getAllAdds() {
		return adds;
	}
	
	@GetMapping("/{id}")
	public Advertisements getAdd(@PathVariable("id") Integer id){
		return adds.get(id);
	}
	
	
	@PostMapping
	public Integer addAdv(@RequestBody @Valid Advertisements add){
		adds.put(adds.size(), add);
		return adds.size()-1;
		
	}
	
	@PutMapping
	public Integer deleteAdd(@RequestParam("id") Integer id){
		adds.remove(id);
		return id; 
	}
	
	
}
