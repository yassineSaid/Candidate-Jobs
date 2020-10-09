package com.esprit.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/jobs")
public class JobRestAPI {
	private String title = "Hello, I'm the Jobs Microservice";
	@Autowired
	private JobService jobService;

	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(this.title);
		return this.title;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Job> createJob(@RequestBody Job job) {
		return new ResponseEntity<>(jobService.addJob(job), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}/{etat}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Job> updateCandidate(@PathVariable(value = "id") int id,
			@PathVariable(value = "etat") boolean etat) {
		return new ResponseEntity<>(jobService.updateJob(id, etat), HttpStatus.OK);
	}
}
