package dao;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DogNameDao {
    public static List<String> getNames() throws IOException {
        Path path = Paths.get("src/main/resources/names.txt");
        List<String> dogNames = Files.readAllLines(path, StandardCharsets.UTF_8);
    return dogNames;
    }

    public static void main(String[] args)throws IOException {
        System.out.println(getNames());
    }

}
