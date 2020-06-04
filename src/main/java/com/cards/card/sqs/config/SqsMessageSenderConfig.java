package com.cards.card.sqs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.cards.card.model.card.Card;

@Component
public class SqsMessageSenderConfig {

	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;

	@Value("${cloud.aws.end-point.uri}")
	private String sqsEndPoint;

	@Async
	public void sendMessage(String payload) {
		queueMessagingTemplate.send(sqsEndPoint, MessageBuilder.withPayload(payload).build());
	}
}
