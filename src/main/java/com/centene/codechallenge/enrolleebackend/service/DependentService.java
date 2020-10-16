package com.centene.codechallenge.enrolleebackend.service;

import com.centene.codechallenge.enrolleebackend.models.Dependent;

public interface DependentService
{
	public boolean addDependent(Dependent dependent, String enrolleeId);
	public boolean deleteDependent(String dependentId, String enrolleeId);
	public Dependent updateDependent(Dependent modifiedDependent);
}
