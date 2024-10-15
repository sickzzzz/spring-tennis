package com.tutorial.relationships;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class TournamentController {

    @Autowired
    TournamentService tournamentService;

    @Autowired
    RegistrationService registrationService;

    @GetMapping("/tournaments")
    public List<Tournament> getAllTournaments(){
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/tournaments/{id}")
    public Tournament getTournament(@PathVariable int id){
        return tournamentService.getTournament(id);
    }

    @PostMapping("/tournaments")
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return tournamentService.addTournament(tournament);
    }

    @PutMapping("/tournaments/{id}/registration/{reg_id}")
    public Tournament assignRegistration(@PathVariable int id, @PathVariable int reg_id) {
        Registration reg = registrationService.getRegistration(reg_id);
        return tournamentService.assignRegistration(id, reg);
    }

    @PutMapping("/{id}/remove_registrations/{reg_id}")
    public Tournament removeRegistration(@PathVariable int id, @PathVariable int reg_id) {
        Registration registration = registrationService.getRegistration(reg_id);
        return tournamentService.removeRegistration(id, registration);
    }

    @DeleteMapping("/tournaments/{id}")
    public void deleteTournament(@PathVariable int id) {
        tournamentService.deleteTournament(id);
    }

}
