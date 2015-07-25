package za.co.no9.pbt;

import java.util.List;

public interface Generator<T> {
    T next();

    String next(String separator);

    Generator<List<T>> list();

    Generator<List<T>> nonEmptyList();

    Generator<T> filter(Predicate<T> predicate);

    Generator<String> asString();

    Generator<String> asString(String separator);
}
