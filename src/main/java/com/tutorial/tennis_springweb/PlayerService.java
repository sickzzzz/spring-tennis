package com.tutorial.tennis_springweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayers(){

        return playerRepository.findAll();
    }
    public Player getPlayer(int id) {

        Optional<Player> player = playerRepository.findById(id);

        Player tempPlayer = null;

        if (player.isPresent())
            tempPlayer = player.get();
        else
            throw new PlayerNotFoundException("Player by ID : " + id + " not present");

        return tempPlayer;

    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(int id, Player player) {

        Player toUpdate = playerRepository.getReferenceById(id);

        toUpdate.setName(player.getName());
        toUpdate.setNationality(player.getNationality());
        toUpdate.setBirthDate(player.getBirthDate());
        toUpdate.setTitles(player.getTitles());

        return playerRepository.save(toUpdate);
    }

    public Player partialUpdatePlayer(int id, Map<String, Object> playerPatch) {

        Optional <Player> player = playerRepository.findById(id);

        if (player.isPresent()){
            for (String updateField : playerPatch.keySet()) {
                Field field = ReflectionUtils.findField(Player.class, updateField);
                if (field != null) {
                    ReflectionUtils.makeAccessible(field);
                    ReflectionUtils.setField(field, player.get(), playerPatch.get(updateField));
                }
            }
        }
        else
            throw new PlayerNotFoundException("Player by ID : " + id + " not present");

        return playerRepository.save(player.get());

    }

    @Transactional
    public Player updateTitles(int id, int titles) {

        Optional <Player> tempPlayer = playerRepository.findById(id);

        if (tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player by ID : " + id + " not present");

        playerRepository.updateTitles(id, titles);
        Optional <Player> updatedPlayer = playerRepository.findById(id);

        return updatedPlayer.get();
    }

    public String deletePlayer(int id) {

        Optional <Player> tempPlayer = playerRepository.findById(id);

        if(tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player by ID : " + id + " not present");

        playerRepository.deleteById(id);
        return "Player id : " + id + " deleted from the DB.";
    }


}
