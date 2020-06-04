package com.cards.card.sqs;

import org.springframework.stereotype.Component;

import com.cards.card.model.card.Card;
import com.cards.card.sqs.config.SqsMessageSenderConfig;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SqsMessageSender {

	private final SqsMessageSenderConfig senderConfig;

	public void sendMessage(String payload) {
		senderConfig.sendMessage(payload);
	}

}
