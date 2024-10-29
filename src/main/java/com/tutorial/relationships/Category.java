package com.tutorial.relationships;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "categoryList",
                cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JsonIgnoreProperties("categoryList")
    private List <TennisTournament> tournamentList = new ArrayList<>();

    public Category(){}

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

    public List <TennisTournament> getTournamentList(){
        return tournamentList;
    }

    public void addTournament(TennisTournament tournament) {
        tournamentList.add(tournament);
    }

    @PreRemove
    private void onDeleteCategory() {
        for (TennisTournament tournament : tournamentList) {
            tournament.getCategoryList().remove(this);
        }
    }
}
