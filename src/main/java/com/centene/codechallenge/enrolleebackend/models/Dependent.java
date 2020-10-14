package com.centene.codechallenge.enrolleebackend.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Dependent
{

	@Id 
	private int id;
	
	private String firstName;
	private String lastName;
	private String homeNumber;
	private String cellNumber;
	
	private LocalDate birthDate;
	
}
