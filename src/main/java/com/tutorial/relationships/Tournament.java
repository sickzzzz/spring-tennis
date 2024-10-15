package com.tutorial.relationships;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="tournament")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tournament_id")
    private List<Registration> registrations;
    public Tournament(){

    }

    public Tournament(String name, String location, List<Registration> registrations) {
        super();
        this.name = name;
        this.location = location;
        this.registrations = registrations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public void addRegistration(Registration registration) {
        registrations.add(registration);
    }

    public void removeRegistration(Registration registration) {
        registrations.remove(registration);
    }
}
