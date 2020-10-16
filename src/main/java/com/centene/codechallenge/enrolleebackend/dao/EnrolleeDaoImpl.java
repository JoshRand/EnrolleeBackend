package com.centene.codechallenge.enrolleebackend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.centene.codechallenge.enrolleebackend.models.Enrollee;
import com.centene.codechallenge.enrolleebackend.repositories.EnrolleeRepo;

@Component
public class EnrolleeDaoImpl implements EnrolleeDao
{
	// Simple enrollee dao implementation using mongorepository
	@Autowired
	EnrolleeRepo enrolleeRepo;

	@Override
	public boolean add(Enrollee enrollee)
	{
		try
		{
			enrolleeRepo.save(enrollee);
			return true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(String enrolleeId)
	{
		try
		{
			enrolleeRepo.deleteById(enrolleeId);
			return true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Enrollee enrollee)
	{
		try
		{
			enrolleeRepo.save(enrollee);
			return true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Enrollee> findAll()
	{
		try
		{
			return enrolleeRepo.findAll();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Enrollee FindById(String enrolleeId)
	{
		return enrolleeRepo.findById(enrolleeId);
	}
	
}
