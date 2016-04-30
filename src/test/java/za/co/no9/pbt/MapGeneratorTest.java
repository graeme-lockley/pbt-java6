package za.co.no9.pbt;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertTrue;
import static za.co.no9.pbt.PBT.forAll;

public class MapGeneratorTest {
    @Test
    public void should_create_a_map_from_generators() throws Exception {
        Generator<Long> keyGenerator = LongGenerator.from(1000, 100000);
        Generator<String> stringGenerator = CharacterGenerator.from('A', 'Z').list(30, 50).asString();

        MapGenerator<Long, String> mapGenerator = new MapGenerator<Long, String>(keyGenerator, stringGenerator);
        mapGenerator.setIteration(100, 200);

        forAll(mapGenerator, new Function<Map<Long, String>>() {
            @Override
            public void test(Map<Long, String> item) throws Exception {
                assertTrue(item.size() <= 200);
                for (Long key : item.keySet()) {
                    assertTrue(key >= 1000 && key <= 100000);
                }
                for (String value : item.values()) {
                    assertTrue(value.length() >= 30 && value.length() <= 50);
                }
            }
        });
    }
}
