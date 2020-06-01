package com.cards.card.controller;

import static com.cards.card.constants.CardConstants.Endpoints.CARD_ENPOINT;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cards.card.entity.CardEntity;
import com.cards.card.entity.PersonalDetailsEntity;
import com.cards.card.model.Card;
import com.cards.card.service.CardService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(CARD_ENPOINT)
@AllArgsConstructor
public class CardController {

	private final CardService cardService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CardEntity> save(@RequestBody @Valid Card cardEntity) {
		
		CardEntity cardEntity2 = CardEntity.builder().personalDetails(PersonalDetailsEntity.builder().firstname("Deepak").build()).build();
		
		return new ResponseEntity<CardEntity>(cardService.save(cardEntity2), HttpStatus.OK);
	}
}