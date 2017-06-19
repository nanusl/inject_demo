package cc.tuhaolicai.hello.text;


import net.kimleo.inject.annotation.Component;

import java.util.List;

@Component
public interface TokenListFactory {
    TokenList create(List<String> tokens);
}
