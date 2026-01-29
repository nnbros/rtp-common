package com.github.nnbros.rtp.common.telegram;

import com.github.guronas.telegram.bot.elements.TelegramElementRegistry;
import com.github.nnbros.rtp.common.RtpTest;
import com.github.nnbros.rtp.common.TestElement;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import static com.github.nnbros.rtp.common.CommonTestUtils.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DefaultTelegramClientTest extends RtpTest {
	private static final String GROUP_NAME = "default";
	private static final String ELEMENT_NAME = "element";

	@Mock
	private TelegramClient telegramClient;

	@Mock
	private TelegramElementRegistry registry;

	@InjectMocks
	private DefaultTelegramClient client;

	@Test
	void buildAndSendMessage() throws Exception {
		SendMessage sendMessage = new SendMessage(TEST_CHAT_ID, TEST_TEXT);

		String groupName = TestElement.testElement.getGroupName();
		String elementName = TestElement.testElement.name();
		when(registry.buildElement(eq(groupName), eq(elementName),
				anyList(), eq(SendMessage.class)))
				.thenReturn(sendMessage);

		client.sendMessage(TEST_USER_ID, TestElement.testElement);

		verify(registry).buildElement(eq(groupName), eq(elementName), anyList(), eq(SendMessage.class));
		verify(telegramClient).execute(sendMessage);
	}
}
