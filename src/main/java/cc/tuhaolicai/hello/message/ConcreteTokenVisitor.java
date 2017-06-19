package cc.tuhaolicai.hello.message;

import cc.tuhaolicai.hello.text.TokenVisitor;
import cc.tuhaolicai.hello.validate.Validator;
import net.kimleo.inject.annotation.Component;
import net.kimleo.inject.annotation.Inject;

import java.io.PrintStream;

@Component
public class ConcreteTokenVisitor implements TokenVisitor {

    @Inject
    private Validator<String> validator;

    @Override
    public void visit(String token) {
        validator.validate(token);
    }

    public TokenVisitor withStream(PrintStream stream) {
        return token -> {
            visit(token);
            if (validator.validate(token))
                stream.println(token);
        };
    }
}
