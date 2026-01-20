package com.github.nnbros.rtp.common.api.dto.error;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record ErrorResponse(
		@JsonProperty("error")
		String error,
		@JsonProperty("timestamp")
		Instant timestamp
) {
}
