package za.co.no9.pbt;

public class IntegerGenerator extends AbstractGenerator<Integer> {
    private final int min;
    private final int max;

    public IntegerGenerator() {
        this(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public IntegerGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Integer next() {
        return (int) ((Math.random() * (max - min)) + min + 0.5);
    }
}
