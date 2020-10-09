package com.esprit.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/candidats")
public class CandidatRestAPI {
	private String title = "Hello, I'm the Candidate Microservice";
	@Autowired
	private CandidateService candidateService;

	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(this.title);
		return this.title;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
		return new ResponseEntity<>(candidateService.addCandidate(candidate), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Candidate> updateCandidate(@PathVariable(value = "id") int id,
			@RequestBody Candidate candidate) {
		return new ResponseEntity<>(candidateService.updateCandidate(id, candidate), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> deleteCandidate(@PathVariable(value = "id") int id) {
		return new ResponseEntity<>(candidateService.deleteCandidate(id), HttpStatus.OK);
	}
}
