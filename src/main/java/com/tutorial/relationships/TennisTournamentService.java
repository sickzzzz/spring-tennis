package com.tutorial.relationships;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TennisTournamentService {

    @Autowired
    TennisTournamentRepository tournamentRepository;

    public List <TennisTournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public TennisTournament getTournament(int id) {
        return tournamentRepository.findById(id).get();
    }

    public TennisTournament addTournament(TennisTournament tournament) {
        tournament.setId(0);
        return tournamentRepository.save(tournament);
    }

    public void deleteTournament(int id) {
        tournamentRepository.deleteById(id);
    }

    public TennisTournament addCategory(int id, Category category){
        TennisTournament tournament = tournamentRepository.findById(id).get();
        tournament.addCategory(category);
        return tournamentRepository.save(tournament);
    }


}
