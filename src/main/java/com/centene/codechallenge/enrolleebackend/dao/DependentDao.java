package com.centene.codechallenge.enrolleebackend.dao;

import java.util.Optional;

import com.centene.codechallenge.enrolleebackend.models.Dependent;

public interface DependentDao
{
	public Dependent add(Dependent dependent);
	public void delete(String dependentId);
	public Dependent findById(String dependentId);
}
