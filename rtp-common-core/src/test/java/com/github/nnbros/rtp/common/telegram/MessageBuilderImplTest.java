package com.github.nnbros.rtp.common.telegram;

import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static com.github.nnbros.rtp.common.CommonTestUtils.TEST_TEXT;
import static com.github.nnbros.rtp.common.CommonTestUtils.TEST_USER_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageBuilderImplTest {

	@Test
	void shouldCreateMessageWithUserIdAndText() {
		MessageBuilderImpl builder = new MessageBuilderImpl();

		SendMessage message = builder.createMessage(TEST_USER_ID, TEST_TEXT);

		assertEquals(String.valueOf(TEST_USER_ID), message.getChatId());
		assertEquals(TEST_TEXT, message.getText());
	}
}
