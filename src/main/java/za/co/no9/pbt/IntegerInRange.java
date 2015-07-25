package za.co.no9.pbt;

public class IntegerInRange extends AbstractGenerator<Integer> {
    private final int min;
    private final int max;

    public IntegerInRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Integer next() {
        return (int) ((Math.random() * (max - min)) + min + 0.5);
    }
}
