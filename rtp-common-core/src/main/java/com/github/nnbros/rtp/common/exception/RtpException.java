package com.github.nnbros.rtp.common.exception;

public class RtpException extends Exception {

	public RtpException() {
	}

	public RtpException(String message, Object... params) {
		super(message.formatted(params));
	}

	public RtpException(String message, Throwable cause, Object... params) {
		super(message.formatted(params), cause);
	}

	public RtpException(Throwable cause) {
		super(cause);
	}
}
