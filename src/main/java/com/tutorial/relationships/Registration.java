package com.tutorial.relationships;

import jakarta.persistence.*;

@Entity
@Table(name = "registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Registration(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
