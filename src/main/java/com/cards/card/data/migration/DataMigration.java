package com.cards.card.data.migration;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;

import lombok.extern.slf4j.Slf4j;

//@ChangeLog(order = "001")
@Slf4j
public class DataMigration{

	@ChangeSet(order = "001", author = "Deepak", id = "insert additional payment method")
	public void insertAdditionalPaymentOption(MongoTemplate mongoTemplate) {
		log.info("Migration completed for Change set 001.");
	}
}
