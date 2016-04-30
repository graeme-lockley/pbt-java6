package za.co.no9.pbt;

import java.util.List;
import java.util.Set;

public interface Generator<T> {
    T next();

    String next(String separator);

    Generator<List<T>> list();

    Generator<List<T>> list(int minLength, int maxLength);

    Generator<List<T>> nonEmptyList();

    Generator<Set<T>> set();

    Generator<Set<T>> set(int minLength, int maxLength);

    Generator<Set<T>> nonEmptySet();

    Generator<T> filter(Predicate<T> predicate);

    Generator<String> asString();

    Generator<String> asString(String separator);
}
