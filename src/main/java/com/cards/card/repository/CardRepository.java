package com.cards.card.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cards.card.entity.CardEntity;

public interface CardRepository extends MongoRepository<CardEntity, Integer> {

}
