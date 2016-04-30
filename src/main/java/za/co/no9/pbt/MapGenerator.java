package za.co.no9.pbt;

import java.util.HashMap;
import java.util.Map;

public class MapGenerator<T1, T2> extends AbstractGenerator<Map<T1, T2>> {
    private final Generator<T1> keyGenerator;
    private final Generator<T2> valueGenerator;
    private Generator<Integer> numberOfElementsGenerator = IntegerGenerator.from(0, 10);

    public MapGenerator(Generator<T1> keyGenerator, Generator<T2> valueGenerator) {
        this.keyGenerator = keyGenerator;
        this.valueGenerator = valueGenerator;
    }

    @Override
    public Map<T1, T2> next() {
        Map<T1, T2> result = new HashMap<T1, T2>();
        int numbersOfElements = numberOfElementsGenerator.next();

        for (int lp = 0; lp < numbersOfElements; lp += 1) {
            result.put(keyGenerator.next(), valueGenerator.next());
        }

        return result;
    }

    public void setIteration(int min, int max) {
        numberOfElementsGenerator = IntegerGenerator.from(min, max);
    }
}
