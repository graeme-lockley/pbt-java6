package za.co.no9.pbt;

public class BooleanGenerator extends AbstractGenerator<Boolean> {
    private final Generator<Integer> generator = IntegerGenerator.from(0, 1);

    public Boolean next() {
        return generator.next() == 1;
    }

    public static BooleanGenerator from() {
        return new BooleanGenerator();
    }
}
