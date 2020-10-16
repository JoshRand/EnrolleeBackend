package com.centene.codechallenge.enrolleebackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centene.codechallenge.enrolleebackend.dao.DependentDao;
import com.centene.codechallenge.enrolleebackend.dao.EnrolleeDao;
import com.centene.codechallenge.enrolleebackend.models.Dependent;
import com.centene.codechallenge.enrolleebackend.models.Enrollee;

@Service
public class DependentServiceImpl implements DependentService
{

	@Autowired
	EnrolleeDao enrolleeDao;
	
	@Autowired
	DependentDao dependentDao;
	
	
	@Override
	public boolean addDependent(Dependent dependent, String enrolleeId)
	{
		List<Dependent> dependentList = new ArrayList<Dependent>();
		Enrollee enrollee = enrolleeDao.findById(enrolleeId);
		if(enrollee == null)
		{
			return false;
		}
		Dependent savedDependent = dependentDao.add(dependent);
		dependentList = enrollee.getDependents();
		dependentList.add(savedDependent);
		return enrolleeDao.add(enrollee);
	}

	@Override
	public boolean deleteDependent(String dependentId, String enrolleeId)
	{
		Enrollee enrollee = enrolleeDao.findById(enrolleeId);
		if(enrollee == null)
		{
			return false;
		}
		for (Dependent dependent : enrollee.getDependents())
		{
			if(dependent.getId().equals(dependentId))
			{
				List<Dependent> deleteDependentList = enrollee.getDependents();
				deleteDependentList.remove(dependent);
				enrollee.setDependents(deleteDependentList);
				enrolleeDao.add(enrollee);
				dependentDao.delete(dependentId);
				return true;
			}
		}
		return false;
	}

	@Override
	public Dependent updateDependent(Dependent modifiedDependent)
	{
		try
		{
			Dependent dependent = dependentDao.findById(modifiedDependent.getId());
			System.out.println(dependent.toString());
			if(modifiedDependent.getFirstName() != null && !modifiedDependent.getFirstName().equals(""))
				dependent.setFirstName(modifiedDependent.getFirstName());
			if(modifiedDependent.getLastName() != null && !modifiedDependent.getLastName().equals(""))
				dependent.setLastName(modifiedDependent.getLastName());
			if(modifiedDependent.getHomeNumber() != null && !modifiedDependent.getHomeNumber().equals(""))
				dependent.setHomeNumber(modifiedDependent.getHomeNumber());
			if(modifiedDependent.getCellNumber() != null && !modifiedDependent.getCellNumber().equals(""))
				dependent.setCellNumber(modifiedDependent.getCellNumber());
			dependentDao.add(dependent);
			
			return dependent;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
