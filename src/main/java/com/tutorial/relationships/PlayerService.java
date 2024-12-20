package com.tutorial.relationships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayerProfileRepository playerProfileRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayer(int id) {
        Optional<Player> player = playerRepository.findById(id);
        Player tempPlayer = null;

        if (player.isPresent())
            tempPlayer = player.get();

        return tempPlayer;
    }

    public Player addPlayer(Player player){
        player.setId(0);
        return playerRepository.save(player);
    }

    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }

    public Player assignProfile(int id, int profileId ) {
        Player player = playerRepository.findById(id).get();
        player.setPlayerProfile(playerProfileRepository.findById(profileId).get());

        return playerRepository.save(player);
    }

    public Player assignRegistration(int id, Registration registration) {
        Player player = playerRepository.findById(id).get();
        player.addRegistration(registration);
        return playerRepository.save(player);
    }

    public Player removeRegistration(int id, Registration registration) {
        Player player = playerRepository.findById(id).get();
        player.removeRegistration(registration);
        return playerRepository.save(player);
    }


}
