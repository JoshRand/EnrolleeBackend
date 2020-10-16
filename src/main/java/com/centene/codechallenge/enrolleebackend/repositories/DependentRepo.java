package com.centene.codechallenge.enrolleebackend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.centene.codechallenge.enrolleebackend.models.Dependent;

public interface DependentRepo extends MongoRepository<Dependent,Integer>
{

}
