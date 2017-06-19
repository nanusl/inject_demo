package cc.tuhaolicai.hello.message;


import cc.tuhaolicai.hello.text.TokenList;
import cc.tuhaolicai.hello.text.Tokenizer;
import net.kimleo.inject.annotation.Component;
import net.kimleo.inject.annotation.Construct;
import net.kimleo.inject.annotation.Qualified;

@Component
public class TokenizedMessageParser implements MessageParser<TokenList> {

    private final Tokenizer tokenizer;

    @Construct
    public TokenizedMessageParser(@Qualified("wordTokenizer") Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Override
    public TokenList parse(String message) {
        return tokenizer.tokenize(message);
    }
}
