package cc.tuhaolicai.hello;

import cc.tuhaolicai.hello.message.Message;
import cc.tuhaolicai.hello.message.MessageFactory;
import cc.tuhaolicai.hello.message.MessageResolver;
import cc.tuhaolicai.hello.strategy.MessageStrategy;
import cc.tuhaolicai.hello.strategy.StrategyFactory;
import net.kimleo.inject.annotation.Application;
import net.kimleo.inject.annotation.Bean;
import net.kimleo.inject.annotation.Config;
import net.kimleo.inject.application.ApplicationBoot;
import net.kimleo.inject.application.Runner;


@Application
@Config
public class HelloWorldApp {

    public static void main(String[] args) throws Exception {
        new ApplicationBoot().run(HelloWorldApp.class);
    }

    @Bean
    public Runner runner(MessageFactory messageFactory,
                         MessageResolver messageResolver,
                         StrategyFactory strategyFactory) {
        return (String... args) -> {
            Message messageBody = messageFactory.create("hello world!", System.out);
            MessageStrategy strategy = strategyFactory.createStrategy(messageBody, messageResolver);
            messageBody.send(strategy);
        };
    }
}
