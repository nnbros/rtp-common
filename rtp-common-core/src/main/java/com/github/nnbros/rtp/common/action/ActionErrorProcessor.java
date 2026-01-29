package com.github.nnbros.rtp.common.action;

import com.github.nnbros.rtp.common.exception.CharacterNotFoundException;
import com.github.nnbros.rtp.common.telegram.DefaultTelegramClient;
import com.github.nnbros.rtp.common.telegram.ui.DefaultElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ActionErrorProcessor {
    private final DefaultTelegramClient telegramClient;

    public void process(String action, long userId, Throwable error) {
        if (error instanceof CharacterNotFoundException) {
            telegramClient.sendMessage(userId, DefaultElement.characterNotFound);
        } else {
            telegramClient.sendMessage(userId, DefaultElement.unknownError);
        }
        log.error("Failed to process action [{}] for the user [{}]", action, userId, error);
    }
}
