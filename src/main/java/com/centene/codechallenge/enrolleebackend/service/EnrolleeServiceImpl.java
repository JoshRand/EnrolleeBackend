package com.centene.codechallenge.enrolleebackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.centene.codechallenge.enrolleebackend.dao.DependentDao;
import com.centene.codechallenge.enrolleebackend.dao.EnrolleeDao;
import com.centene.codechallenge.enrolleebackend.models.Dependent;
import com.centene.codechallenge.enrolleebackend.models.Enrollee;

@Service
public class EnrolleeServiceImpl implements EnrolleeService
{
	@Autowired
	EnrolleeDao enrolleeDao;
	
	@Autowired
	DependentDao dependentDao;
	
	@Override
	public boolean addEnrollee(Enrollee enrollee)
	{
		return enrolleeDao.add(enrollee);
	}

	@Override
	public Enrollee updateEnrollee(Enrollee modifiedEnrollee)
	{
		try
		{
			Enrollee enrollee = enrolleeDao.FindById(modifiedEnrollee.getId());
			System.out.println(enrollee.toString());
			if(modifiedEnrollee.isActivationStatus() != true && modifiedEnrollee.isActivationStatus() != false)
				enrollee.setActivationStatus(modifiedEnrollee.isActivationStatus());
			if(modifiedEnrollee.getFirstName() != null)
				enrollee.setFirstName(modifiedEnrollee.getFirstName());
			if(modifiedEnrollee.getLastName() != null)
				enrollee.setLastName(modifiedEnrollee.getLastName());
			if(modifiedEnrollee.getHomeNumber() != null)
				enrollee.setHomeNumber(modifiedEnrollee.getHomeNumber());
			if(modifiedEnrollee.getCellNumber() != null)
				enrollee.setCellNumber(modifiedEnrollee.getCellNumber());
			enrolleeDao.add(enrollee);
			
			return enrollee;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteEnrollee(String enrolleeId)
	{
		return enrolleeDao.delete(enrolleeId);
	}

	@Override
	public List<Enrollee> findAllEnrollees()
	{
		return enrolleeDao.findAll();
	}

	@Override
	public Enrollee findById(String enrolleeId)
	{
		return enrolleeDao.FindById(enrolleeId);
	}

	@Override
	public boolean addDependent(Dependent dependent, String enrolleeId)
	{
		List<Dependent> dependentList = new ArrayList<Dependent>();
		Enrollee enrollee = enrolleeDao.FindById(enrolleeId);
		if(enrollee == null)
		{
			return false;
		}
		Dependent savedDependent = dependentDao.add(dependent);
		dependentList = enrollee.getDependents();
		dependentList.add(savedDependent);
		return enrolleeDao.add(enrollee);
	}

}
