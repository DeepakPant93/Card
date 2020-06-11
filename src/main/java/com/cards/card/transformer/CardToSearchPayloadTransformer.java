package com.cards.card.transformer;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.cards.card.context.CardContext;
import com.cards.card.model.card.Address;
import com.cards.card.model.card.Card;
import com.cards.card.model.card.Location;
import com.cards.card.model.search.SearchPayload;

@Component
public class CardToSearchPayloadTransformer implements Function<Card, SearchPayload> {

	@Override
	public SearchPayload apply(Card card) {

		Address address = card.getCompanyDetails().getAddress();
		Location companyLocation = address.getLocation();

		return SearchPayload.builder()
				.userId(CardContext.getUserId())
				.cardId(card.getId())
				.cardStatus(card.getStatus())
				.cardType(card.getType())
				.companyname(card.getCompanyDetails().getName())
				.latitude(companyLocation.getLatitude())
				.longitude(companyLocation.getLongitude())
				.address(address.getAddressLine1())
				.city(address.getCity())
				.thumbnailUrl(card.getCompanyDetails().getThumbnailUrl())
				.build();
	}
}
