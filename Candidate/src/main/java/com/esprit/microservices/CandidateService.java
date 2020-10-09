package com.esprit.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
	@Autowired
	private CandidateRepository candidateRepository;
	
	public Candidate addCandidate(Candidate candidate) {
		return candidateRepository.save(candidate);
	}
	public Candidate updateCandidate(int id, Candidate newCandidate) {
		if (candidateRepository.findById(id).isPresent()) {
			Candidate existingCandidate = candidateRepository.findById(id).get();
			existingCandidate.setNom(newCandidate.getNom());
			existingCandidate.setEmail(newCandidate.getEmail());
			existingCandidate.setPrenom(newCandidate.getPrenom());
			
			return candidateRepository.save(existingCandidate);
		}
		else return null;
	}
	public String deleteCandidate(int id) {
		if (candidateRepository.findById(id).isPresent()) {
			candidateRepository.deleteById(id);
			return "Candidat supprimé";
		}
		else return "Candidat non supprimé";
	}
}
