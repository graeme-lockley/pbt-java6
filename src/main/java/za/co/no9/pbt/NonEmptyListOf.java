package za.co.no9.pbt;

public class NonEmptyListOf<T> extends ListOf<T> {
    public NonEmptyListOf(Generator<T> generator) {
        super(generator);
        setLengthRange(1, 10);
    }
}
