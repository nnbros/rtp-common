package com.github.nnbros.rtp.common.api.dto.character;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Character {

	@JsonProperty("characterName")
	protected String name;
}
