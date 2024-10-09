package com.tutorial.relationships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PlayerProfileController {

    @Autowired
    PlayerProfileRepositoryService profileService;

    @GetMapping("/profiles")
    public List <PlayerProfile> getAllProfile(){
        return profileService.getAllPlayerProfiles();
    }

    @GetMapping("/profiles/{id}")
    public PlayerProfile getProfile(@PathVariable int id) {
        return profileService.getPlayerProfile(id);
    }

    @PostMapping("/profiles")
    public PlayerProfile addProfile(@RequestBody PlayerProfile profile) {
        return profileService.addPlayerProfile(profile);
    }

    @DeleteMapping("/profiles/{id}")
    public void deleteProfile(@PathVariable int id) {
        profileService.deletePlayerProfile(id);
    }

}
