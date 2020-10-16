package com.centene.codechallenge.enrolleebackend.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "enrollees")
public class Enrollee
{	
	
	@Id
	private String id;
	private boolean activationStatus;
	
	private String firstName;
	private String lastName;
	private String homeNumber;
	private String cellNumber;
	private LocalDate birthDate;
	@DBRef 
	private List<Dependent> dependents;

	@Autowired
	public Enrollee(String firstName, String lastName, boolean activationStatus, LocalDate birthDate,
			String homeNumber, String cellNumber, List<Dependent> dependents)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.activationStatus = activationStatus;
		this.birthDate = birthDate;
		this.homeNumber = homeNumber;
		this.cellNumber = cellNumber;
		this.dependents = dependents;
	}

	public List<Dependent> getDependents()
	{
		return dependents;
	}

	public void setDependents(List<Dependent> dependents)
	{
		this.dependents = dependents;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

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

	@Override
	public String toString()
	{
		return "Enrollee [id=" + id + ", activationStatus=" + activationStatus + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", homeNumber=" + homeNumber + ", cellNumber=" + cellNumber
				+ ", birthDate=" + birthDate + ", dependents=" + dependents + "]";
	}
	
	
	
}
