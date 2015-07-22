package za.co.no9.pbt;

public class FilterGenerator<T> extends AbstractGenerator<T> {
    private final Generator<T> generator;
    private final Predicate<T> predicate;

    public FilterGenerator(Generator<T> generator, Predicate<T> predicate) {
        this.generator = generator;
        this.predicate = predicate;
    }

    @Override
    public T next() {
        while (true) {
            T result = generator.next();

            if (predicate.evaluate(result)) {
                return result;
            }
        }
    }
}
