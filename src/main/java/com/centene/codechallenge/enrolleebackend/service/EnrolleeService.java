package com.centene.codechallenge.enrolleebackend.service;

import java.util.List;

import com.centene.codechallenge.enrolleebackend.models.Dependent;
import com.centene.codechallenge.enrolleebackend.models.Enrollee;

public interface EnrolleeService
{
	public boolean addEnrollee(Enrollee enrollee);
	public Enrollee updateEnrollee(Enrollee modifiedEnrollee);
	public boolean deleteEnrollee(String enrolleeId);
	public Enrollee findById(String enrolleeId);
	public List<Enrollee> findAllEnrollees();
	
}
