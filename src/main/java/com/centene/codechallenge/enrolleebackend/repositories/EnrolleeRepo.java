package com.centene.codechallenge.enrolleebackend.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.centene.codechallenge.enrolleebackend.models.Enrollee;

public interface EnrolleeRepo extends MongoRepository<Enrollee,Integer>
{

}
