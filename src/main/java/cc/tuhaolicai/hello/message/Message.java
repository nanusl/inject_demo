package cc.tuhaolicai.hello.message;


import cc.tuhaolicai.hello.strategy.MessageStrategy;

public interface Message {
    String getPayload();

    void send(MessageStrategy ms);
}
