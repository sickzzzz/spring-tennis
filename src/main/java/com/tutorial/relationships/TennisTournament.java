package com.tutorial.relationships;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="tennis_tournament")
public class TennisTournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "tournament_categories",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonIgnoreProperties("tournamentList")
    private List<Category> categoryList = new ArrayList<>();

    public TennisTournament(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategoryList(){
        return categoryList;
    }

    public void addCategory(Category category){
        categoryList.add(category);
        category.addTournament(this);
    }

    public void removeCategory(Category category) {
        categoryList.remove(category);
        category.getTournamentList().remove(this);
    }


}
