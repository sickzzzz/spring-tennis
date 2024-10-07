package com.tutorial.tennis_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Player> getAllPlayers() {
        String sql = "SELECT * FROM Player";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player>(Player.class));
    }

    public Player getPlayerById(int id) {
        String sql = "SELECT * FROM Player where id=?";
        return jdbcTemplate.queryForObject(sql,
                                  new BeanPropertyRowMapper<Player>(Player.class),
                                  new Object[] {id});
    }

    public int insertPlayer(Player player) {
        String sql = "INSERT INTO Player (Id, Name, Nationality, Birth_date, Titles)"
                        + " VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                                    new Object [] {
                                            player.getId(),
                                            player.getName(),
                                            player.getNationality(),
                                            new Timestamp(player.getBirthDate().getTime()),
                                            player.getTitles()
                                    }
                );
    }

    public int updatePlayer(Player player) {
        String sql = "UPDATE Player SET " +
                     "Name=?, Nationality=?, Birth_date=? " +
                     "Titles=? WHERE id=?";
        return jdbcTemplate.update( sql,
                                    new Object [] {
                                            player.getName(),
                                            player.getNationality(),
                                            new Timestamp(player.getBirthDate().getTime()),
                                            player.getTitles(),
                                            player.getId()
                                    }
                );
    }

    public int deletePlayerById(int id) {
        String sql = "DELETE FROM Player WHERE id=?";
        return jdbcTemplate.update(sql, new Object[]{id});
    }

}
