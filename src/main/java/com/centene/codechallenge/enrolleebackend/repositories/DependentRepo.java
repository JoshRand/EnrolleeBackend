package com.centene.codechallenge.enrolleebackend.repositories;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.centene.codechallenge.enrolleebackend.models.Dependent;
@Repository
public interface DependentRepo extends MongoRepository<Dependent,Integer>
{
	public Dependent findById(String id);
	public Dependent deleteById(String id);
}
