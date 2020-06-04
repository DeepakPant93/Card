package com.cards.card.controller;

import static com.cards.card.constants.CardConstants.Endpoints.CARD_ENPOINT;

import java.math.BigInteger;

import javax.validation.Valid;

import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cards.card.model.card.Card;
import com.cards.card.service.CardService;
import com.cards.card.sqs.SqsMessageSender;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(CARD_ENPOINT)
@AllArgsConstructor
public class CardController {

	private final CardService cardService;
	private final SqsMessageSender sender;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Card> save(@RequestBody @Valid Card card) {
		return new ResponseEntity<>(cardService.save(card), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Card> getByCardId(@PathVariable("id") BigInteger id) {
		return new ResponseEntity<>(cardService.getByCardId(id), HttpStatus.OK);
	}

	@SqsListener("search-queue")
	public void receive(String card) {
		System.out.println("Hi I am received. " + card);
	}
	
	@GetMapping(value = "/send")
	public void send() {
		
		System.out.println("Hi I am received. ");
		sender.sendMessage("Hello AWS!!");
	}
}
