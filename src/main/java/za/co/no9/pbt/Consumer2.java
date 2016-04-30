package za.co.no9.pbt;

public interface Consumer2<T1, T2> {
    void accept(T1 item1, T2 item2) throws Exception;
}
