package cc.tuhaolicai.hello.proxy;

public interface Transform<T> {
    T apply(T self);
}
