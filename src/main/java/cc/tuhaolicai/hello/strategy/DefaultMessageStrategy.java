package cc.tuhaolicai.hello.strategy;


import cc.tuhaolicai.hello.message.Message;
import cc.tuhaolicai.hello.message.MessageResolver;

import java.io.PrintStream;

public class DefaultMessageStrategy implements MessageStrategy {

    private final MessageResolver<PrintStream> messageResolver;
    private final Message message;

    @SuppressWarnings("unchecked")
    public DefaultMessageStrategy(MessageResolver messageResolver, Message message) {
        this.messageResolver = messageResolver;
        this.message = message;
    }

    public void sendMessage(PrintStream stream) {
        String message = this.message.getPayload();
        messageResolver.resolve(message, stream);
    }
}
