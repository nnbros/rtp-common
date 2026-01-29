package com.github.nnbros.rtp.common.autoconfigure;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@Setter
@Getter
@ConfigurationProperties(prefix = "rtp-bot")
public class RtpBotProperties {
	private boolean webhookEnabled = true;
	@NotNull
	private URI url = URI.create("https://rtp-bot.ru:8443");
	@NotBlank
	private String webhookPath = "rtp";
	@Pattern(regexp = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$")
	private String ip;
	@NotBlank
	private String token;
}
