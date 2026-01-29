package com.github.nnbros.rtp.common.autoconfigure;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import(TelegramBotConfiguration.class)
public class RtpCommonAutoConfiguration {
}
