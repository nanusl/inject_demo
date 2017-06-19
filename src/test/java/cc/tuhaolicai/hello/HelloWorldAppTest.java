package cc.tuhaolicai.hello;

import cc.tuhaolicai.hello.message.Message;
import cc.tuhaolicai.hello.message.MessageFactory;
import cc.tuhaolicai.hello.message.MessageResolver;
import cc.tuhaolicai.hello.message.PrintMessageResolver;
import cc.tuhaolicai.hello.strategy.DefaultMessageStrategy;
import cc.tuhaolicai.hello.strategy.StrategyFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HelloWorldAppTest {

    public static final String HELLO_WORLD_MESSAGE = "hello world!";
    public Message message;


    private StrategyFactory strategyFactory;
    private HelloWorldApp app;
    private MessageResolver printMessageResolver;
    private MessageFactory messageFactory;
    private DefaultMessageStrategy strategy;

    @Before
    public void setUp() throws Exception {
        strategyFactory = mock(StrategyFactory.class);
        printMessageResolver = mock(PrintMessageResolver.class);
        messageFactory = mock(MessageFactory.class);
        message = mock(Message.class);
        strategy = new DefaultMessageStrategy(printMessageResolver, message);
        when(strategyFactory.createStrategy(any(Message.class), eq(printMessageResolver)))
                .thenReturn(strategy);

        when(messageFactory.create(anyString(), any(PrintStream.class))).thenReturn(message);

        app = new HelloWorldApp();
    }

    @Test
    public void should_run_run() throws Exception {
        app.runner(messageFactory, printMessageResolver, strategyFactory).run();

        verify(messageFactory).create(anyString(), any(PrintStream.class));
        verify(strategyFactory).createStrategy(message, printMessageResolver);
        verify(message).send(strategy);
    }

    @Test
    @Ignore
    public void should_run_main() throws Exception {
        HelloWorldApp.main(new String[]{});
    }
}