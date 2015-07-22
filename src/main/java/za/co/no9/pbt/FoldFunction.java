package za.co.no9.pbt;

public interface FoldFunction<S, T> {
    T execute(T result, S next);
}
