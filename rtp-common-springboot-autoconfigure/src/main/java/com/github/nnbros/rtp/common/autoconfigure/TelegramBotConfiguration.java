package com.github.nnbros.rtp.common.autoconfigure;

import com.github.guronas.telegram.bot.elements.TelegramElementRegistry;
import com.github.nnbros.rtp.common.telegram.DefaultTelegramClient;
import com.github.nnbros.rtp.common.telegram.MessageBuilder;
import com.github.nnbros.rtp.common.telegram.MessageBuilderImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Configuration
@EnableConfigurationProperties(RtpBotProperties.class)
public class TelegramBotConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public MessageBuilder messageBuilder() {
		return new MessageBuilderImpl();
	}

	@Bean
	@ConditionalOnMissingBean
	public TelegramClient telegramClient(RtpBotProperties properties) {
		return new OkHttpTelegramClient(properties.getToken());
	}

	//TODO Refactor and add flag to check if TelegramElementRegistry is needed. Better do it in Telegram elements lib.
	@Bean("defaultTelegramClient")
	@ConditionalOnProperty(prefix = "elements", name = "working-directory")
	public DefaultTelegramClient defaultTelegramClient(TelegramClient telegramClient, TelegramElementRegistry elementRegistry) {
		return new DefaultTelegramClient(telegramClient, elementRegistry);
	}
}
