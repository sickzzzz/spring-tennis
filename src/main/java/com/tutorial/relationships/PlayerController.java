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

    @Autowired
    RegistrationService registrationService;

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id){
        return playerService.getPlayer(id);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
    }

    @PutMapping("/players/{id}/profile/{profileId}")
    public Player assignProfile(@PathVariable int id, @PathVariable int profileId) {
        return playerService.assignProfile(id, profileId);
    }

    @PutMapping("/players/{id}/registrations/{reg_id}")
    public Player assignRegistration(@PathVariable int id, @PathVariable int reg_id) {
        Registration registration = registrationService.getRegistration(reg_id);
        return playerService.assignRegistration(id, registration);
    }

    @PutMapping("/players/{id}/remove_registrations/{reg_id}")
    public Player removeRegistration(@PathVariable int id, @PathVariable int reg_id) {
        Registration registration = registrationService.getRegistration(reg_id);
        return playerService.removeRegistration(id, registration);
    }

}
