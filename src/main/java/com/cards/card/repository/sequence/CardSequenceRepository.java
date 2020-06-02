package com.cards.card.repository.sequence;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.math.BigInteger;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.cards.card.entity.sequence.CardSequenceEntity;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CardSequenceRepository {

    private static final String SEQUENCE_NAME = "cardSequence";

    private final MongoOperations mongo;

    public BigInteger getNextSequence() {
        return mongo.findAndModify(query(where("_id").is(SEQUENCE_NAME)), new Update().inc("seq", 1),
                options().returnNew(true).upsert(true), CardSequenceEntity.class).getSeq();
    }
}
