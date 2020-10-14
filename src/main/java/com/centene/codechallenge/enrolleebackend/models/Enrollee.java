package com.centene.codechallenge.enrolleebackend.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "enrollees")
public class Enrollee
{	
	@Id
	private int id;
	private boolean activationStatus;
	
	private String firstName;
	private String lastName;
	private String homeNumber;
	private String cellNumber;
	private LocalDate birthDate;
	
	private List<Dependent> dependents;
	
	public Enrollee(String firstName, String lastName, boolean activationStatus, String birthDate,
			String homeNumber, String cellNumber, List<Dependent> dependents)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.activationStatus = activationStatus;
		this.birthDate = LocalDate.parse(birthDate);
		this.homeNumber = homeNumber;
		this.cellNumber = cellNumber;
		this.dependents = dependents;
	}
	
	public void addDependent(Dependent dependent)
	{
		if(!dependents.contains(dependent))
			dependents.add(dependent);
	}
	
	public void delDependent(Dependent dependent)
	{
		if(dependents.contains(dependent))
			dependents.remove(dependent);
	}

	public void modDependent(Dependent dependent)
	{
		
	}
	
//	public int getId()
//	{
//		return id;
//	}

	public boolean isActivationStatus()
	{
		return activationStatus;
	}

	public void setActivationStatus(boolean activationStatus)
	{
		this.activationStatus = activationStatus;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getHomeNumber()
	{
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber)
	{
		this.homeNumber = homeNumber;
	}

	public String getCellNumber()
	{
		return cellNumber;
	}

	public void setCellNumber(String cellNumber)
	{
		this.cellNumber = cellNumber;
	}

	public LocalDate getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate)
	{
		this.birthDate = birthDate;
	}
	
	
	
}
