package com.github.nnbros.rtp.common.action;

import com.github.nnbros.rtp.common.RtpTest;
import com.github.nnbros.rtp.common.exception.CharacterNotFoundException;
import com.github.nnbros.rtp.common.telegram.DefaultTelegramClient;
import com.github.nnbros.rtp.common.telegram.ui.DefaultElement;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.stream.Stream;

import static com.github.nnbros.rtp.common.CommonTestUtils.TEST_ACTION;
import static com.github.nnbros.rtp.common.CommonTestUtils.TEST_USER_ID;
import static org.mockito.Mockito.verify;

class ActionErrorProcessorTest extends RtpTest {
	@Mock
	private DefaultTelegramClient telegramClient;

	@InjectMocks
	private ActionErrorProcessor processor;

	@ParameterizedTest
	@MethodSource("provideActionErrorProcessorTestParams")
	void process(Exception e, DefaultElement expectedElement) {
		processor.process(TEST_ACTION, TEST_USER_ID, e);
		verify(telegramClient).sendMessage(TEST_USER_ID, expectedElement);
	}

	private static Stream<Arguments> provideActionErrorProcessorTestParams() {
		return Stream.of(
				Arguments.of(new CharacterNotFoundException(), DefaultElement.characterNotFound),
				Arguments.of(new RuntimeException(), DefaultElement.unknownError)
		);
	}
}
