package com.cards.card.controller;

import static com.cards.card.constants.CardConstants.Endpoints.CARD_ENPOINT;

import java.math.BigInteger;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cards.card.model.card.Card;
import com.cards.card.service.CardService;
import java.util.Map;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
@RequestMapping(CARD_ENPOINT)
@AllArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Card> save(@RequestBody @Valid Card card) {
        return new ResponseEntity<>(cardService.save(card), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Card> getById(@PathVariable("id") BigInteger id) {
        return new ResponseEntity<>(cardService.getByCardId(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Card> updateCard(@PathVariable("id") BigInteger id, @RequestBody @Valid Card card) {
        card.setId(id);
        return new ResponseEntity<>(cardService.updateCard(card), HttpStatus.OK);
    }

    @PatchMapping(value = "{/id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Card> patchCard(@PathVariable("id") BigInteger id, @RequestBody Map<Object, Object> fields) {
        return new ResponseEntity<>(cardService.patchCard(id, fields), HttpStatus.OK);
    }
}
