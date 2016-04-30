package za.co.no9.pbt;

public class NonEmptySetOfGenerator<T> extends SetOfGenerator<T> {
    public NonEmptySetOfGenerator(Generator<T> generator) {
        super(generator);
        setIteration(1, 10);
    }
}
