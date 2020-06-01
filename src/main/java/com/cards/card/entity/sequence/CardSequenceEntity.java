package com.cards.card.entity.sequence;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CardSequence")
public class CardSequenceEntity {
	
	@Id
	private String id;
	private BigInteger seq;
}
