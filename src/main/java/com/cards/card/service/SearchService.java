package com.cards.card.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.cards.card.enums.CardTypeEnum;
import com.cards.card.model.card.Card;
import com.cards.card.model.search.SearchPayload;
import com.cards.card.sqs.SqsMessageSender;
import com.cards.card.transformer.CardToSearchPayloadTransformer;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SearchService {

	private final CardToSearchPayloadTransformer searchPayloadTransformer;
	private final SqsMessageSender messageSender;
        /**
         * @description  sendMessage function is use Only Business card will go to the search service
         * 
         * @param card 
         */

	public void sendMessage(Card card) {

		if (Objects.nonNull(card) && CardTypeEnum.BUSINESS.name().equals(card.getType())) {
			SearchPayload searchPayload = searchPayloadTransformer.apply(card);
			messageSender.sendMessage(searchPayload);
		}
	}

}
