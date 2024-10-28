package com.tutorial.relationships;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TennisTournamentRepository extends JpaRepository<TennisTournament, Integer> {
}


