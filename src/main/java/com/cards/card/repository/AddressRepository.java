package com.cards.card.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cards.card.entity.AddressEntity;

public interface AddressRepository extends MongoRepository<AddressEntity, BigInteger> {

}
