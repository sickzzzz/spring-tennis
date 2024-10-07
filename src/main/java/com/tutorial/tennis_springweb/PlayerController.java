package com.tutorial.tennis_springweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Application";
    }

    @GetMapping("/players")
    public List<Player> getPlayers(){
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable int id) {

        return playerService.getPlayer(id);
    }

    @PostMapping("/players")
    public Player insertPlayer(@RequestBody Player player) {
        player.setId(0);
        return playerService.addPlayer(player);
    }

    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable int id, @RequestBody Player player) {

        return playerService.updatePlayer(id, player);
    }

    @PatchMapping("/players/{id}")
    public Player partialUpdatePlayer(@PathVariable int id, @RequestBody Map<String, Object> patchPlayer) {
        return playerService.partialUpdatePlayer(id, patchPlayer);
    }

    @PatchMapping("/players/{id}/titles")
    public Player updateTitles(@PathVariable int id, @RequestBody int titles) {
        return playerService.updateTitles(id, titles);
    }

    @DeleteMapping("/players/{id}")
    public String deletePlayer(@PathVariable int id) {
        return playerService.deletePlayer(id);
    }


}
