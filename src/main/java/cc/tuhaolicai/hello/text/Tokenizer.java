package cc.tuhaolicai.hello.text;


import net.kimleo.inject.annotation.Component;

@FunctionalInterface
@Component
public interface Tokenizer {
    TokenList tokenize(String text);
}
