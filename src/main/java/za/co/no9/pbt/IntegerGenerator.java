package za.co.no9.pbt;

public class IntegerGenerator extends AbstractGenerator<Integer> {
    private final int min;
    private final int max;

    protected IntegerGenerator() {
        this(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    protected IntegerGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static Generator<Integer> from(int min, int max) {
        return new IntegerGenerator(min, max);
    }

    @Override
    public Integer next() {
        return (int) ((Math.random() * (max - min)) + min + 0.5);
    }
}
