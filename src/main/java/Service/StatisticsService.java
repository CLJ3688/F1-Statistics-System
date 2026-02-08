package Service;

import Repository.FileRepository;
import model.Driver;
import model.RaceDetails;
import model.RaceResult;
import model.Team;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticsService {
    FileRepository fileRepository = new FileRepository();
    //get basic Data Set
    List<Driver> driverList = fileRepository.getAllDrivers("Driver_Details.csv");
    List<RaceResult> raceResultList = fileRepository.getAllRaceResult("Race_Results.csv");
    List<Team> teamList = fileRepository.getAllTeams("Team_Details.csv");
    List<RaceDetails> raceDetailsList = fileRepository.getAllRaceDetails("Race_Details.csv");

//    List<RaceResult> raceResultList = RaceResult.get2024RaceResults();
    //Get a Map<id, name>
    Map<String, String> idToNameMap = driverList.stream()
            .collect(Collectors.toMap(Driver::driverId,Driver::name));
    List<String> podiumPosition = List.of("1","2","3");

    public record DriverPodiumStats (
            String id,
            String name,
            int totalRaces,
            long podiumCounts,
            double rate
    ){}



//    public List<Driver> getAllDrivers() {
//        return this.driverList.stream()
//                .sorted(Comparator.comparing(Driver::team)
//                                .thenComparing(Driver::name))
//                .toList();
//    }
    public List<Driver> getAllDrivers() {
        return this.driverList.stream()
                .sorted(Comparator.comparing(Driver::driverId))
                .toList();
    }

    public List<RaceResult> getRaceResult() {
        return this.raceResultList;
    }

//    public List<DriverPodiumStats> getDriverPodiumStats(String teamName) {
//        //透過 filter 篩選 driver
//        Set<String> teamDriversId = driverList.stream()
//                .filter(driver -> driver.team().contains(teamName))
//                .map(Driver::id)
//                .collect(Collectors.toSet());
//
//        return teamDriversId.stream()
//                .map(driverId -> {
//                    String driverName = idToNameMap.getOrDefault(driverId, "Unknown");
//
//                    List<RaceResult> driverResult = raceResultList.stream()
//                            .filter(raceResult -> raceResult.id().equals(driverId))
//                            .toList();
//
//                    int totalRace = driverResult.size();
//                    long podiumCount = driverResult.stream()
//                            .filter(raceResult -> podiumPosition.contains(raceResult.position()))
//                            .count();
//                    double podiumRate = (totalRace > 0) ? (double) podiumCount / totalRace * 100 : 0.0;
//                    return new DriverPodiumStats(driverId,driverName,totalRace,podiumCount,podiumRate);
//                })
//                .sorted((driver1, driver2) -> Double.compare(driver2.rate(), driver1.rate()))
//                .toList();
//    }
}
