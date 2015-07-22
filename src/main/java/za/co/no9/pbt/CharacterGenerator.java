package za.co.no9.pbt;

public class CharacterGenerator extends AbstractGenerator<Character> {
    private final Generator<Integer> generator = new IntegerInRange(0, 255);

    @Override
    public Character next() {
        return (char) generator.next().intValue();
    }
}
