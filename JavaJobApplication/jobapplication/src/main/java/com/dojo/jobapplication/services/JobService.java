package com.dojo.jobapplication.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojo.jobapplication.models.Job;
import com.dojo.jobapplication.repositories.JobRepository;

@Service
public class JobService {

	private final JobRepository jobRepository;

//	<<---------------Defining Constructor--------------->>
	
	public JobService(JobRepository jobRepository) {
		
		this.jobRepository = jobRepository;
	}
	
//	<<---------------Create--------------->>
	
	public Job createJob(Job job) {
		return jobRepository.save(job);
	}
	
//	<<---------------Read--------------->>
	public List<Job> findAllJobs() {
		return jobRepository.findAll();
	}
	
	public Job findJobById(Long id) {
		return jobRepository.findById(id).get();
	}
	
//	<<---------------Update--------------->>
	public Job updateJob(Job job) {
		return jobRepository.save(job);
	}
	
//	<<---------------Destroy--------------->>
	public void deleteJob(Job job) {
		jobRepository.delete(job);
	}
	
}
