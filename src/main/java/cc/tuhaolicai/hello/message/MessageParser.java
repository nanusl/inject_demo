package cc.tuhaolicai.hello.message;


import net.kimleo.inject.annotation.Component;

@Component
public interface MessageParser<T> {
    T parse(String messageBody);
}
