package com.cards.card.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cards.card.context.CardContext;
import com.cards.card.entity.CardEntity;
import com.cards.card.execption.ResourceNotAuthorizedException;
import com.cards.card.execption.ResourceNotFoundException;
import com.cards.card.execption.SystemException;
import com.cards.card.model.card.Card;
import com.cards.card.repository.CardRepository;
import com.cards.card.transformer.entity.EntityToModelTransformer;
import com.cards.card.transformer.model.ModelToEntityTransformer;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CardService {

	private final CardRepository cardRepository;
	private final ModelToEntityTransformer entityTransformer;
	private final EntityToModelTransformer modelTransformer;
	private final SearchService searchService;

	public Card getByCardId(BigInteger id) {
		Optional<CardEntity> cardEntityTemp = cardRepository.findById(id);

		if (!cardEntityTemp.isPresent()) {
			throw new ResourceNotFoundException("Unable to found any card for id " + id);
		}

		if (!CardContext.getUserId().equalsIgnoreCase(cardEntityTemp.get().getUserId())) {
			throw new ResourceNotAuthorizedException(String
					.format("User %s is not authorized to view the card with id %s", CardContext.getUserId(), id));
		}

		return modelTransformer.apply(cardEntityTemp.get());
	}

	public Card save(Card card) {
		try {
			CardEntity cardEntity = cardRepository.save(entityTransformer.apply(card));
			card.setId(cardEntity.getId());

			// Sending card details to search service
			searchService.sendMessage(card);
			return card;
		} catch (Exception exp) {
			throw new SystemException(
					"Excaption occured while saving card details for " + card.getPersonalDetails().getFirstname(), exp);
		}
	}

}
