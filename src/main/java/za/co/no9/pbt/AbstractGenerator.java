package za.co.no9.pbt;

import java.util.List;

public abstract class AbstractGenerator<T> implements Generator<T> {
    @Override
    public Generator<List<T>> nonEmptyList() {
        return new NonEmptyListOf<T>(this);
    }

    @Override
    public Generator<T> filter(Predicate<T> predicate) {
        return new FilterGenerator<T>(this, predicate);
    }

    @Override
    public Generator<String> asString() {
        return asString("");
    }

    @Override
    public Generator<String> asString(String separator) {
        return new AppendGenerator(this, separator);
    }
}
