package com.cards.card.repository.sequence;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.cards.card.entity.sequence.CardSequenceEntity;

@Component
public class CardSequenceRepository {

	@Autowired
	private MongoOperations mongo;

	public BigInteger getNextSequence(String seqName) {
		return mongo.findAndModify(query(where("_id").is(seqName)), new Update().inc("seq", 1),
				options().returnNew(true).upsert(true), CardSequenceEntity.class).getSeq();
	}
}
