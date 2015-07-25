package za.co.no9.pbt;

import java.util.List;

public class ListOf<T> extends AbstractGenerator<List<T>> {
    private final Generator<T> generator;
    private Generator<Integer> lengthGenerator = new IntegerInRange(0, 10);

    public ListOf(Generator<T> generator) {
        this.generator = generator;
    }

    public void setLengthRange(int minLength, int maxLength) {
        lengthGenerator = new IntegerInRange(minLength, maxLength);
    }

    @Override
    public List<T> next() {
        return MyCollections.times(lengthGenerator.next(), new Supplier<T>() {
            @Override
            public T get() {
                return generator.next();
            }
        });
    }
}
