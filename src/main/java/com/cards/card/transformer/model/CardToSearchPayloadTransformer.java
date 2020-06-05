package com.cards.card.transformer.model;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.cards.card.model.card.Card;
import com.cards.card.model.card.Location;
import com.cards.card.model.search.SearchPayload;

@Component
public class CardToSearchPayloadTransformer implements Function<Card, SearchPayload> {

	@Override
	public SearchPayload apply(Card card) {

		Location companyLocation = card.getCompanyDetails().getAddress().getLocation();

		return SearchPayload.builder()
				.cardId(card.getId())
				.cardStatus(card.getStatus())
				.cardType(card.getType())
				.companyname(card.getCompanyDetails().getName())
				.latitude(companyLocation.getLatitude())
				.longitude(companyLocation.getLongitude())
				.locationName(companyLocation.getName())
				.thumbnailUrl(card.getCompanyDetails().getThumbnailUrl())
				.build();
	}

}
