package cc.tuhaolicai.hello.strategy;

import cc.tuhaolicai.hello.message.Message;
import cc.tuhaolicai.hello.message.MessageResolver;
import net.kimleo.inject.annotation.Component;

@Component
public interface StrategyFactory {
    MessageStrategy createStrategy(Message message, MessageResolver messageResolver);
}
