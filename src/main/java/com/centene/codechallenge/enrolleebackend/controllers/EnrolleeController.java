package com.centene.codechallenge.enrolleebackend.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.centene.codechallenge.enrolleebackend.dao.EnrolleeDao;
import com.centene.codechallenge.enrolleebackend.models.Dependent;
import com.centene.codechallenge.enrolleebackend.models.Enrollee;
import com.centene.codechallenge.enrolleebackend.service.DependentService;
import com.centene.codechallenge.enrolleebackend.service.EnrolleeService;

@RestController
@RequestMapping("/enrollee")
public class EnrolleeController
{
	
	@Autowired
	EnrolleeService enrolleeService;
	
	@Autowired
	DependentService dependentService;
	
	// Add a new Enrollee
	@PostMapping
	public ResponseEntity<String> addEnrollee(@RequestBody Enrollee enrollee)
	{
		if(enrolleeService.addEnrollee(enrollee))
			return new ResponseEntity<String>("Enrollee added?"+true,HttpStatus.CREATED);
		return new ResponseEntity<String>("Enrollee added?"+false,HttpStatus.CONFLICT);
		
	}
	
	// Modify Existing Enrollee
	@PatchMapping
	public ResponseEntity<Enrollee> modEnrollee(@RequestBody Enrollee modifiedEnrollee)
	{
		return new ResponseEntity<Enrollee>(enrolleeService.updateEnrollee(modifiedEnrollee),
				(modifiedEnrollee.getId() == null)?HttpStatus.BAD_REQUEST:HttpStatus.ACCEPTED);
	}
	
	// Delete Existing Enrollee
	@DeleteMapping
	public ResponseEntity<String> delEnrollee(@RequestParam String enrolleeId)
	{
		if(enrolleeService.deleteEnrollee(enrolleeId))
			return new ResponseEntity<String>("Deleted enrollee id="+enrolleeId+" true",HttpStatus.ACCEPTED);
		return new ResponseEntity<String>("Deleted enrollee id="+enrolleeId+" false",HttpStatus.CONFLICT);
	}
	
	
	// Returns an Enrollees
	@GetMapping
	public ResponseEntity<Enrollee> getEnrollee(@RequestParam String enrolleeId)
	{
		return new ResponseEntity<Enrollee>(enrolleeService.findById(enrolleeId),HttpStatus.ACCEPTED);
	}
	
	// Returns a list of Enrollees
	@GetMapping("/all")
	public ResponseEntity<List<Enrollee>> getEnrollees()
	{
		return new ResponseEntity<List<Enrollee>>(enrolleeService.findAllEnrollees(),HttpStatus.ACCEPTED);
	}
	
}
