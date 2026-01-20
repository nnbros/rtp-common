package com.github.nnbros.rtp.common.api.dto.character;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Archetype {
	NEUTRAL("🥋"),
	SWORDSMAN("🗡"),
	CAVALRY("🏇"),
	SPEARMAN("🔱");

	private final String emoji;
}
