package dogs.service;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class NameGenerator {
    private final Random random;
    private final List<String> dogNames;

    public NameGenerator(Random random, List<String> dogNames) {
        this.random = random;
        this.dogNames = dogNames;
    }

    public String getName() throws IOException {
        return dogNames.get(random.nextInt(dogNames.size()));
    }
}
