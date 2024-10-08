package com.tutorial.relationships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerProfileRepositoryService {

    @Autowired
    PlayerProfileRepository playerProfileRepository;

    public List<PlayerProfile> getAllPlayerProfiles(){
        return playerProfileRepository.findAll();
    }

    public PlayerProfile getPlayerProfile(int id) {

        Optional<PlayerProfile> playerProfile = playerProfileRepository.findById(id);
        PlayerProfile tempProfile = null;

        if (playerProfile.isPresent())
            tempProfile = playerProfile.get();

        return tempProfile;
    }

    public PlayerProfile addPlayerProfile(PlayerProfile profile) {
        profile.setId(0);
        return playerProfileRepository.save(profile);
    }

    public void deletePlayerProfile(int id) {
        playerProfileRepository.deleteById(id);
    }


}
