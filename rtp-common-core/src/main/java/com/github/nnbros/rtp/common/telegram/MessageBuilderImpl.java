package com.github.nnbros.rtp.common.telegram;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class MessageBuilderImpl implements MessageBuilder {

	@Override
	public SendMessage createMessage(Long userId, String text) {
		return SendMessage.builder()
				.chatId(userId)
				.text(text)
				.build();
	}
}
