package com.github.nnbros.rtp.common.exception;

public class RtpRuntimeException extends RuntimeException {

	public RtpRuntimeException() {
	}

	public RtpRuntimeException(String message, Object... params) {
		super(message.formatted(params));
	}

	public RtpRuntimeException(String message, Throwable cause, Object... params) {
		super(message.formatted(params), cause);
	}

	public RtpRuntimeException(Throwable cause) {
		super(cause);
	}
}
