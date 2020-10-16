package com.centene.codechallenge.enrolleebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.centene.codechallenge.enrolleebackend.models.Dependent;
import com.centene.codechallenge.enrolleebackend.repositories.DependentRepo;
@Component
public class DependentDaoImpl implements DependentDao
{

	@Autowired
	DependentRepo dependentRepo;
	
	@Override
	public Dependent add(Dependent dependent)
	{
		return dependentRepo.save(dependent);
	}

	@Override
	public void delete(String dependentId)
	{
		// TODO Auto-generated method stub
		
	}

}
