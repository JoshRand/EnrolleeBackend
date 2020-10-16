package com.centene.codechallenge.enrolleebackend.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "dependents")
public class Dependent
{

	@Id 
	private String id;
	
	private String firstName;
	private String lastName;
	private String homeNumber;
	private String cellNumber;
	
	private LocalDate birthDate;

	public Dependent(String firstName, String lastName, String homeNumber, String cellNumber, LocalDate birthDate)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.homeNumber = homeNumber;
		this.cellNumber = cellNumber;
		this.birthDate = birthDate;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
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
		return "Dependent [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", homeNumber="
				+ homeNumber + ", cellNumber=" + cellNumber + ", birthDate=" + birthDate + "]";
	}
	
	
	
}
