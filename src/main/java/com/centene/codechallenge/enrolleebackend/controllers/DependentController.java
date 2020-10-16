package com.centene.codechallenge.enrolleebackend.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.centene.codechallenge.enrolleebackend.models.Dependent;
import com.centene.codechallenge.enrolleebackend.service.DependentService;

@RestController
@RequestMapping("/dependent")
public class DependentController
{
	
	@Autowired
	DependentService dependentService;
	
	// Add Dependent to Enrollee
	@PostMapping
	public ResponseEntity<String> addDepenedent(@RequestParam String enrolleeId, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String homeNumber, @RequestParam String cellNumber, @RequestParam String birthDate)
	{
		Dependent dependent = new Dependent(firstName,lastName,homeNumber,cellNumber,LocalDate.parse(birthDate));
		System.out.println(dependent.toString());
		return new ResponseEntity<String>("Adding dependent to Enrollee?= " + dependentService.addDependent(dependent,enrolleeId),HttpStatus.CREATED);
	}
	
	// delete Dependent from Enrollee
	@DeleteMapping
	public ResponseEntity<String> delDepenedent(@RequestParam String dependentId, @RequestParam String enrolleeId)
	{
		return new ResponseEntity<String>("Deleted dependent? " + dependentService.deleteDependent(dependentId,enrolleeId),HttpStatus.ACCEPTED);
	}
	
	// Modify Existing Dependent
	@PatchMapping
	public ResponseEntity<Dependent> modDependent(@RequestBody Dependent modifiedDependent)
	{
		return new ResponseEntity<Dependent>(dependentService.updateDependent(modifiedDependent),
				(modifiedDependent.getId() == null)?HttpStatus.BAD_REQUEST:HttpStatus.ACCEPTED);
	}
}
