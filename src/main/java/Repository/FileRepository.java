package Repository;

import model.Driver;
import model.RaceDetails;
import model.RaceResult;
import model.Team;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileRepository {

    private final String DATA_PATH = "data";

    public List<Driver> getAllDrivers(String fileName) {
        //get file path
        Path path = Paths.get(DATA_PATH ,fileName);

        //try-with-resources
        try (Stream<String> lines = Files.lines(path)){
            return lines
                    .skip(1) //skip 標題列 (driverId, code, forename, surname, dob, nationality)
                    .map(line -> line.split(","))
                    .filter(parts -> parts.length >= 6) //確保無空行或格式錯誤
                    .map(parts -> new Driver(
                            parts[0].trim(), //driverId
                            (parts[2].trim() +" " + parts[3].trim())//name
                    ))
                    .toList();
        } catch (IOException e) {
            System.err.println("讀取 " + fileName + " 發生錯誤 : " + e.getMessage());
            return List.of();
        }
    }

    public List<Team> getAllTeams(String fileName) {
        Path path = Paths.get(DATA_PATH, fileName);

        try(Stream<String> lines = Files.lines(path)) {
            return lines
                    .skip(1)
                    .map(line -> line.split(","))
                    .filter(parts -> parts.length >=3)
                    .map(parts -> new Team(
                            parts[0].trim(),
                            parts[1].trim(),
                            parts[2].trim()
                    ))
                    .toList();
        } catch (IOException e) {
            System.err.println("讀取 " + fileName + " 發生錯誤 : " + e.getMessage());
            return List.of();
        }
    }

    public List<RaceResult> getAllRaceResult(String fileName) {
        Path path = Paths.get(DATA_PATH,fileName);

        try(Stream<String> lines = Files.lines(path)) {
            return lines
                    .skip(1)
                    .map(line -> line.split(","))
                    .filter(parts -> parts.length >= 9)
                    .map(parts -> new RaceResult(
                            parts[0].trim(), //resultId
                            parts[1].trim(),//raceId
                            parts[2].trim(),//teamId
                            parts[3].trim(),//driverId
                            parts[4].trim(),//grid
                            parts[5].trim(),//position
                            Integer.parseInt(parts[6].trim()),//points(int)
                            parts[7].trim(),//year
                            parts[8].trim()//round
                    ))
                    .toList();
        } catch (IOException e) {
            System.err.println("讀取 " + fileName + " 發生錯誤 : "  + e.getMessage());
            return List.of();
        }
    }

    public List<RaceDetails> getAllRaceDetails(String fileName) {
        Path path = Paths.get(DATA_PATH, fileName);

        try(Stream<String> lines = Files.lines(path)) {
            return lines
                    .skip(1)
                    .map(line -> line.split(","))
                    .filter(parts -> parts.length >=6)
                    .map(parts -> new RaceDetails(
                            parts[0].trim(),//raceId
                            parts[1].trim(),//raceName
                            Integer.parseInt(parts[2].trim()),//laps(int)
                            parts[3].trim(),//circuitName
                            parts[4].trim(),//location
                            parts[5].trim()//country
                    ))
                    .toList();
        } catch (IOException e) {
            System.err.println("讀取 " + fileName + " 發生錯誤 : " + e.getMessage());
            return List.of();
        }
    }
}
