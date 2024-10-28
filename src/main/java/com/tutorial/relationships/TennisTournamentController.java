package com.tutorial.relationships;
import java.util.List;

import org.aspectj.lang.annotation.DeclareError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TennisTournamentController {

    @Autowired
    TennisTournamentService tournamentService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/tennis-tournaments")
    public List <TennisTournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/tennis-tournaments/{id}")
    public TennisTournament getTournament(@PathVariable int id) {
        return tournamentService.getTournament(id);
    }

    @PostMapping("/tennis-tournaments")
    public TennisTournament addTournament(@RequestBody TennisTournament tournament) {
        return tournamentService.addTournament(tournament);
    }

    @DeleteMapping("/tennis-tournaments/{id}")
    public void deleteTournament(@PathVariable int id) {
        tournamentService.deleteTournament(id);
    }

    @PutMapping("/{id}/categories/{cat_id}")
    public TennisTournament addCategory(@PathVariable int id, @PathVariable int cat_id) {
        Category category = categoryService.getCategory(cat_id);
        return tournamentService.addCategory(id, category);
    }

}
