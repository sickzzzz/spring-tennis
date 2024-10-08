package com.tutorial.relationships;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "player_profile")
public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String twitter;

    public PlayerProfile(){

    }

    public PlayerProfile(String twitter) {
        super();
        this.twitter = twitter;
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

    @Override
    public String toString() {
        return "PlayerProfile{" +
                "id=" + id +
                ", twitter='" + twitter + '\'' +
                '}';
    }
}
