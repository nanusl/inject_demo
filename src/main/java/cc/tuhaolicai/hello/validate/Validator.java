package cc.tuhaolicai.hello.validate;


import net.kimleo.inject.annotation.Component;

@Component
@FunctionalInterface
public interface Validator<T> {
    boolean validate(T t);
}
