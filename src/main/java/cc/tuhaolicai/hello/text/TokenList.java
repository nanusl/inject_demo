package cc.tuhaolicai.hello.text;


import net.kimleo.inject.annotation.Component;

@Component
public interface TokenList extends Iterable<String> {
    void accept(TokenVisitor visitor);
}
