package com.esprit.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
	@Autowired
	private JobRepository jobRepository;

	public Job addCandidate(Job job) {
		return jobRepository.save(job);
	}

	public Job addJob(Job job) {
		return jobRepository.save(job);
	}

	public Job updateJob(int id, boolean etat) {
		if (jobRepository.findById(id).isPresent()) {
			Job existingJob = jobRepository.findById(id).get();
			existingJob.setEtat(etat);

			return jobRepository.save(existingJob);
		} else
			return null;
	}
}
