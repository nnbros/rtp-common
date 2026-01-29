package com.github.nnbros.rtp.common.action;

import com.github.nnbros.rtp.common.telegram.UpdateType;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.objects.Update;

public record ActionContext(
		@NonNull String action,
		@NonNull Long userId,
		@NonNull UpdateType updateType,
		@NonNull Update update,
		@Nullable Integer messageId,
		@Nullable String actionData
) {
}
