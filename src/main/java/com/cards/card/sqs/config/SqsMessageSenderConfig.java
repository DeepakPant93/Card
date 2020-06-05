package com.cards.card.sqs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cards.card.model.search.SearchPayload;
import com.cards.card.util.CardJsonParser;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SqsMessageSenderConfig {

	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;

	@Value("${cloud.aws.end-point.uri}")
	private String sqsEndPoint;

	@Async
	public void sendMessage(SearchPayload payload) {
		String jsonPayload = CardJsonParser.toJson(payload);
		if (!StringUtils.isEmpty(jsonPayload)) {
			queueMessagingTemplate.send(sqsEndPoint, MessageBuilder.withPayload(CardJsonParser.toJson(payload)).build());
			log.info("Successfully sent the payload in 'search-queue' for card id {}.", payload.getCardId());
		}
	}
}
