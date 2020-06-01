package com.cards.card.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

//import com.github.mongobee.MongoClientURI;
import com.github.mongobee.Mongobee;

//@Configuration
public class MongobeeConfig {

	private static final String DATA_MIGRATION_PACKAGE = "com.cards.card.data.migration";

	@Autowired
	MongoTemplate mongoTemplate;

	@Bean
	public Mongobee mongobee() {
		String mongoURI = "mongodb://localhost:27017/CardsDB";
//		MongoClientURI mongoClientURI = null;
		// Add the correct connection settings
		Mongobee runner = new Mongobee(mongoURI);

//		runner.setMongoTemplate(mongoTemplate);
		runner.setChangeLogsScanPackage(DATA_MIGRATION_PACKAGE);
		return runner;
	}
}
//"mongodb://localhost:27017/CardsDB"