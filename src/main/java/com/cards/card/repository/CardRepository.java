package com.cards.card.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cards.card.entity.CardEntity;
import java.math.BigInteger;

public interface CardRepository extends MongoRepository<CardEntity, BigInteger> {

}
