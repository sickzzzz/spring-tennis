package com.tutorial.relationships;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping(name = "/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping(name = "/players/{id}")
    public Player getPlayer(@PathVariable int id){
        return playerService.getPlayer(id);
    }

    @PostMapping(name = "/players")
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @DeleteMapping(name = "/players/{id}")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
    }

    @PutMapping(name="/players/{id}/profile/{profileId}")
    public Player assignProfile(@PathVariable int id, @PathVariable int profileId) {
        return playerService.assignProfile(id, profileId);
    }



}