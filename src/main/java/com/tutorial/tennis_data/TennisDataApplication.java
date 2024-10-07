package com.tutorial.tennis_data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Date;

@SpringBootApplication
public class TennisDataApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PlayerDao dao;

	public static void main(String[] args) {
		SpringApplication.run(TennisDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Delete player 2 : {}", dao.deletePlayerById(2));

		logger.info("All the players : {}", dao.getAllPlayers());

	}
}
