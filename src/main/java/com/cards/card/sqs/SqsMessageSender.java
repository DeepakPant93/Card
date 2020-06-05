package com.cards.card.sqs;

import org.springframework.stereotype.Component;

import com.cards.card.model.search.SearchPayload;
import com.cards.card.sqs.config.SqsMessageSenderConfig;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SqsMessageSender {

	private final SqsMessageSenderConfig senderConfig;

	public void sendMessage(SearchPayload payload) {
		senderConfig.sendMessage(payload);
	}

}
