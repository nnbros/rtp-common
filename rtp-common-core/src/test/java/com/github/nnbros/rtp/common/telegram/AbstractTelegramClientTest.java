package com.github.nnbros.rtp.common.telegram;

import com.github.guronas.telegram.bot.elements.TelegramElementRegistry;
import com.github.nnbros.rtp.common.RtpTest;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import static com.github.nnbros.rtp.common.CommonTestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class AbstractTelegramClientTest extends RtpTest {
	@Mock
	private TelegramClient telegramClient;

	@Mock
	private TelegramElementRegistry registry;

	@InjectMocks
	private TestTelegramClient client;

	@Test
	void sendRemoveInlineKeyboardMessage() throws Exception {
		client.sendRemoveInlineKeyboardMessage(TEST_USER_ID, TEST_MESSAGE_ID);

		ArgumentCaptor<EditMessageReplyMarkup> captor = ArgumentCaptor.forClass(EditMessageReplyMarkup.class);
		verify(telegramClient).execute(captor.capture());
		EditMessageReplyMarkup request = captor.getValue();
		assertEquals(TEST_CHAT_ID, request.getChatId());
		assertEquals(TEST_MESSAGE_ID, request.getMessageId());
	}

	private static class TestTelegramClient extends AbstractTelegramClient {
		private TestTelegramClient(TelegramClient telegramClient, TelegramElementRegistry elementRegistry) {
			super(telegramClient, elementRegistry);
		}
	}
}
