package com.github.nnbros.rtp.common.action;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.Nullable;

@Data
@AllArgsConstructor
public class ActionResult<T> {
	private final ActionContext actionContext;
	private final boolean isSuccessful;
	@Nullable
	private final T value;

	public ActionResult(ActionContext actionContext) {
		this(actionContext, true, null);
	}

	public ActionResult(ActionContext actionContext, T value) {
		this(actionContext, true, value);
	}

	public ActionResult(ActionContext actionContext, boolean isSuccessful) {
		this(actionContext, true, null);
	}
}
