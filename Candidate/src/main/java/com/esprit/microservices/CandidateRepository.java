package com.esprit.microservices;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
	@Query("select c from Candidate c where c.nom like :nom")
	public Page<Candidate> candidateByNom(@Param("nom") String nom, Pageable pageable);
}
