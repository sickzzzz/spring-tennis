package com.tutorial.relationships;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "player_profile")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String twitter;
    @OneToOne(mappedBy = "playerProfile")
    private Player player;

    public PlayerProfile(){

    }

    public PlayerProfile(String twitter) {
        super();
        this.twitter = twitter;
    }

    public PlayerProfile(String twitter, Player player) {
        super();
        this.twitter = twitter;
        this.player = player;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "PlayerProfile{" +
                "id=" + id +
                ", twitter='" + twitter + '\'' +
                ", player='" + player.getName() + '\'' +
                '}';
    }
}
