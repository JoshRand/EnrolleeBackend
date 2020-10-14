package com.centene.codechallenge.enrolleebackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centene.codechallenge.enrolleebackend.models.Dependent;
import com.centene.codechallenge.enrolleebackend.models.Enrollee;
import com.centene.codechallenge.enrolleebackend.repositories.EnrolleeRepo;

@RestController
@RequestMapping("/enrollee")
public class EnrolleeController
{
	
	@Autowired
	EnrolleeRepo enrolleeRepo;
	
	// Add a new Enrollee
	@PostMapping
	public ResponseEntity<Enrollee> addEnrollee(@RequestBody Enrollee enrollee)
	{
		enrolleeRepo.save(enrollee);
		//System.out.println(enrollee.getId());
		return new ResponseEntity<Enrollee>(enrollee,HttpStatus.CREATED);
	}
	
	// Modify Existing Enrollee
	@PutMapping
	public ResponseEntity<Integer> modEnrollee()
	{
		return new ResponseEntity<Integer>(2,HttpStatus.ACCEPTED);
	}
	
	// Modify Existing Enrollee
	@DeleteMapping
	public ResponseEntity<Integer> delEnrollee(@RequestBody Enrollee enrollee)
	{
		enrolleeRepo.delete(enrollee);
		return new ResponseEntity<Integer>(3,HttpStatus.ACCEPTED);
	}
	
	// Add dependant to Enrollee
	@PostMapping("/dependent")
	public ResponseEntity<Integer> addDepenedent(@RequestBody Dependent dependent)
	{
		return new ResponseEntity<Integer>(4,HttpStatus.CREATED);
	}
	
	// delete dependant to Enrollee
	@DeleteMapping("/dependent")
	public ResponseEntity<Integer> delDepenedent()
	{
		return new ResponseEntity<Integer>(5,HttpStatus.ACCEPTED);
	}
		
	// Returns a list of Enrollees
	@GetMapping
	public ResponseEntity<Integer> getEnrollees()
	{
		return new ResponseEntity<Integer>(6,HttpStatus.ACCEPTED);
	}
	
}
