package com.github.nnbros.rtp.common.telegram;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface MessageBuilder {

	SendMessage createMessage(Long userId, String text);
}
