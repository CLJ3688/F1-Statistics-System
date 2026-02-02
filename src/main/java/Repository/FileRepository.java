package Repository;

import model.Driver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileRepository {

    private final String DATA_PATH = "data";

    public List<Driver> get2024Drivers(String fileName) {
        //get file path
        Path path = Paths.get(DATA_PATH ,fileName);

        //try-with-resources
        try (Stream<String> lines = Files.lines(path)){
            return lines
                    .skip(1) //skip 標題列 (id, code, forename, surname, dob, nationality, team)
                    .map(line -> line.split(","))
                    .filter(parts -> parts.length >= 7) //確保無空行或格式錯誤
                    .map(parts -> new Driver(
                            parts[0].trim(), //id
                            (parts[2].trim() +" " + parts[3].trim()),
                            parts[6].trim()
                    ))
                    .toList();
        } catch (IOException e) {
            System.err.println("讀取 Driver 檔案發生錯誤 : " + e.getMessage());
            return List.of();
        }
    }
}
