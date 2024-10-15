package com.tutorial.relationships;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    @Autowired
    TournamentRepository tournamentRepository;

    public List <Tournament> getAllTournaments(){
        return tournamentRepository.findAll();
    }

    public Tournament getTournament(int id){
        return tournamentRepository.findById(id).get();
    }

    public Tournament addTournament(Tournament tournament){
        tournament.setId(0);
        return tournamentRepository.save(tournament);
    }

    public void deleteTournament(int id) {
        tournamentRepository.deleteById(id);
    }

    public Tournament assignRegistration(int id, Registration registration) {
        Tournament tournament = tournamentRepository.findById(id).get();
        tournament.addRegistration(registration);
        return tournamentRepository.save(tournament);
    }

    public Tournament removeRegistration(int id, Registration registration) {
        Tournament tournament = tournamentRepository.findById(id).get();
        tournament.removeRegistration(registration);
        return tournamentRepository.save(tournament);
    }


}
