package za.co.no9.pbt;

public class CharacterGenerator extends AbstractGenerator<Character> {
    private final Generator<Integer> generator;

    public CharacterGenerator() {
        this((char) 0, (char) 255);
    }

    public CharacterGenerator(char min, char max) {
        generator = new IntegerGenerator((int) min, (int) max);
    }

    @Override
    public Character next() {
        return (char) generator.next().intValue();
    }
}
