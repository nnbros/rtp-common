package com.github.nnbros.rtp.common.api.dto.character;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ActiveCharacterClass(
		@JsonProperty("type") Archetype type,
		@JsonProperty("name") String name,
		@JsonProperty("baseHp") Integer baseHp,
		@JsonProperty("baseAtk") Integer baseAtk,
		@JsonProperty("baseDef") Integer baseDef,
		@JsonProperty("advantageBonus") Float advantageBonus,
		@JsonProperty("experience") Long experience) {
}
