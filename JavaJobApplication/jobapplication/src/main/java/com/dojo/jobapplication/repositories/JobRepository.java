package com.dojo.jobapplication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojo.jobapplication.models.Job;

public interface JobRepository extends CrudRepository<Job, Long> {

	public List<Job> findAll();
	
}
