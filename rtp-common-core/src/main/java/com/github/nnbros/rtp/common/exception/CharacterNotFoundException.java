package com.github.nnbros.rtp.common.exception;

public class CharacterNotFoundException extends RtpRuntimeException {
	public CharacterNotFoundException() {
	}

	public CharacterNotFoundException(long userId) {
		super("Character for the user [%s] was not found", userId);
	}

	public CharacterNotFoundException(int characterId) {
		super("Character with id [%s] was not found", characterId);
	}
}
