package za.co.no9.pbt;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SetOfGenerator<T> extends AbstractGenerator<Set<T>> {
    private final Generator<T> generator;
    private Generator<Integer> lengthGenerator = IntegerGenerator.from(0, 10);

    public SetOfGenerator(Generator<T> generator) {
        this.generator = generator;
    }

    public void setIteration(int minimumIteration, int maximumIteration) {
        lengthGenerator = IntegerGenerator.from(minimumIteration, maximumIteration);
    }

    @Override
    public Set<T> next() {
        return times(lengthGenerator.next(), new Supplier<T>() {
            @Override
            public T get() {
                return generator.next();
            }
        });
    }

    @Override
    public String next(final String separator) {
        return join(times(lengthGenerator.next(), new Supplier<String>() {
            @Override
            public String get() {
                return generator.next(separator);
            }
        }), separator);
    }

    private static <T> Set<T> times(int n, Supplier<T> supplier) {
        Set<T> result = new HashSet<T>();

        for (int lp = 0; lp < n; lp += 1) {
            result.add(supplier.get());
        }

        return result;
    }

    private static String join(Collection collection, String separator) {
        StringBuilder sb = new StringBuilder();
        for (Object o : collection) {
            sb.append(separator).append(o.toString());
        }
        return sb.substring(separator.length());
    }
}
