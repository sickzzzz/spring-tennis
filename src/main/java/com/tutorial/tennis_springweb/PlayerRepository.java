package com.tutorial.tennis_springweb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Modifying
    @Query("UPDATE Player p SET p.titles=:titles WHERE p.id=:id")
    public void updateTitles(@Param("id") int id, @Param("titles") int titles);
}
