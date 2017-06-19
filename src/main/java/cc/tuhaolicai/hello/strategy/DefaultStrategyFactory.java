package cc.tuhaolicai.hello.strategy;


import cc.tuhaolicai.hello.message.Message;
import cc.tuhaolicai.hello.message.MessageResolver;
import net.kimleo.inject.annotation.Component;
import net.kimleo.inject.annotation.Factory;

@Factory(product = MessageStrategy.class)
@Component
public class DefaultStrategyFactory implements StrategyFactory {

    private static StrategyFactory instance;

    private DefaultStrategyFactory() {
    }

    public static StrategyFactory getInstance() {
        if (instance == null)
            instance = new DefaultStrategyFactory();
        return instance;
    }

    public MessageStrategy createStrategy(final Message message, MessageResolver messageResolver) {
        return new DefaultMessageStrategy(messageResolver, message);
    }

}
