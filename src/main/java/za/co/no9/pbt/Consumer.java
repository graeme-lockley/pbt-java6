package za.co.no9.pbt;

public interface Consumer<T> {
    void accept(T item) throws Exception;
}
