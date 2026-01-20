package com.github.nnbros.rtp.common;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.chat.Chat;
import org.telegram.telegrambots.meta.api.objects.message.Message;

public class CommonTestUtils {
	public static final int TEST_UPDATE_ID = 456;
	public static final String TEST_TEXT = "util";
	public static final long TEST_USER_ID = 123L;
	public static final String CHAT_PRIVATE_TYPE = "private";

	public static Message createTestMessage() {
		return createTestMessage(TEST_TEXT);
	}

	public static Message createTestMessage(String text) {
		Chat chat = Chat.builder()
				.type(CHAT_PRIVATE_TYPE)
				.id(TEST_USER_ID)
				.build();
		User from = User.builder()
				.id(TEST_USER_ID)
				.firstName("TestUser")
				.isBot(false)
				.build();
		return Message.builder()
				.text(text)
				.chat(chat)
				.from(from)
				.build();
	}

	public static Update createTestEmptyUpdate() {
		Update update = new Update();
		update.setUpdateId(TEST_UPDATE_ID);
		return update;
	}

	public static Update createTestMessageUpdate() {
		Update update = new Update();
		update.setMessage(createTestMessage());
		update.setUpdateId(TEST_UPDATE_ID);
		return update;
	}

	public static Update createTestEditedMessageUpdate() {
		return createTestEditedMessageUpdate(createTestMessage());
	}

	public static Update createTestEditedMessageUpdate(Message message) {
		Update update = new Update();
		update.setEditedMessage(message);
		update.setUpdateId(TEST_UPDATE_ID);
		return update;
	}
}
