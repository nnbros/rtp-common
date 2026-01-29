package com.github.nnbros.rtp.common;

import com.github.nnbros.rtp.common.telegram.ui.Element;

public enum TestElement implements Element {
	testElement;

	@Override
	public String getGroupName() {
		return "testGroup";
	}
}
