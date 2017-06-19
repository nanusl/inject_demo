package cc.tuhaolicai.hello.config;

import cc.tuhaolicai.hello.validate.Validator;
import net.kimleo.inject.annotation.Bean;
import net.kimleo.inject.annotation.Config;

@Config
public class HelloWorldConfiguration {
    @Bean
    public Validator<String> tokenValidator() {
        return (token) -> token != null && !token.isEmpty();
    }
}
