package za.co.no9.pbt;

public class NonEmptyListOfGenerator<T> extends ListOfGenerator<T> {
    public NonEmptyListOfGenerator(Generator<T> generator) {
        super(generator);
        setLengthRange(1, 10);
    }
}
