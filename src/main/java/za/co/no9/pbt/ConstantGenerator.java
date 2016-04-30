package za.co.no9.pbt;

public class ConstantGenerator<T> extends AbstractGenerator<T> {
    private T value;

    public ConstantGenerator(T value) {
        this.value = value;
    }

    @Override
    public T next() {
        return value;
    }
}
