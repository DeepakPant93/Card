package com.cards.card.service;

import org.springframework.stereotype.Service;

import com.cards.card.entity.CardEntity;
import com.cards.card.repository.CardRepository;
import com.cards.card.repository.sequence.CardSequenceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CardService {

	private static final String SEQUENCE_NAME = "dishSequence";

	private CardRepository cardRepository;
	private CardSequenceRepository sequence;

	public CardEntity save(CardEntity cardEntity) {
		cardEntity.setId(sequence.getNextSequence(SEQUENCE_NAME));
		return cardRepository.save(cardEntity);
	}
}
