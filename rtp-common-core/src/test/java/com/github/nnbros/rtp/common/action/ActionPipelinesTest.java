package com.github.nnbros.rtp.common.action;

import com.github.nnbros.rtp.common.RtpTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.function.Consumer;
import java.util.function.Function;

import static com.github.nnbros.rtp.common.CommonTestUtils.createTestActionContext;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ActionPipelinesTest extends RtpTest {
	private static final String IGNORED_VALUE = "ignored";
	private static final String PAYLOAD = "payload";

	@Mock
	private Consumer<ActionContext> actionProcessor;

	@Mock
	private Consumer<ActionContext> nextHandler;

	@Mock
	private Function<ActionContext, ActionResult<String>> resultProcessor;

	@Mock
	private Consumer<ActionResult<String>> resultHandler;

	@Mock
	private Consumer<ActionResult<String>> altResultHandler;

	@Test
	void executeActionAndNextHandlerInOrder() {
		ActionContext context = createTestActionContext();
		ActionPipeline pipeline = ActionPipelines.create(actionProcessor, nextHandler);

		pipeline.execute(context);

		var inOrder = inOrder(actionProcessor, nextHandler);
		inOrder.verify(actionProcessor).accept(context);
		inOrder.verify(nextHandler).accept(context);
	}

	@Test
	void passResultToNextHandler() {
		ActionContext context = createTestActionContext();
		ActionResult<String> result = new ActionResult<>(context, PAYLOAD);

		when(resultProcessor.apply(context)).thenReturn(result);

		ActionPipeline pipeline = ActionPipelines.create(resultProcessor, resultHandler);

		pipeline.execute(context);

		verify(resultProcessor).apply(context);
		verify(resultHandler).accept(result);
		assertEquals(context, result.getActionContext());
		assertEquals(PAYLOAD, result.getValue());
	}

	@Test
	void useAltHandlerWhenResultIsUnsuccessful() {
		ActionContext context = createTestActionContext();
		ActionResult<String> result = new ActionResult<>(context, false, PAYLOAD);

		when(resultProcessor.apply(context)).thenReturn(result);

		ActionPipeline pipeline = ActionPipelines.create(resultProcessor, resultHandler, altResultHandler);

		pipeline.execute(context);

		verify(resultHandler, never()).accept(result);
		verify(altResultHandler).accept(result);
		assertFalse(result.isSuccessful());
	}

	@Test
	void returnNoOpConsumer() {
		assertDoesNotThrow(() -> ActionPipelines.emptyConsumer().accept(IGNORED_VALUE));
	}
}
