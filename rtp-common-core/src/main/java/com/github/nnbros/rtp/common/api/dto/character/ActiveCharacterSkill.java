package com.github.nnbros.rtp.common.api.dto.character;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ActiveCharacterSkill(
		@JsonProperty("name") String name,
		@JsonProperty("skillType") SkillType skillType,
		@JsonProperty("effectiveAgainst") Archetype effectiveAgainst) {
}
