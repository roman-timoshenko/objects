package dogs.dao;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DogNameDao {
    private final Path path;
    public DogNameDao(String filePath) {
        this.path = Paths.get(filePath);
    }

    public List<String> getNames() throws IOException {
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

}
