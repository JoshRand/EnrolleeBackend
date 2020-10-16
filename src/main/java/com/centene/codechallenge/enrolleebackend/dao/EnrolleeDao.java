package com.centene.codechallenge.enrolleebackend.dao;

import java.util.List;

import com.centene.codechallenge.enrolleebackend.models.Enrollee;

public interface EnrolleeDao
{
	public boolean add(Enrollee enrollee);
	public boolean delete(String enrolleeId);
	public boolean update(Enrollee enrollee);
	public Enrollee findById(String enrolleeId);
	public List<Enrollee> findAll();
}
