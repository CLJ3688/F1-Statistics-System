package controller;

import model.Driver;
import model.RaceResult;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        //setting hardcode of f1 driver 2024 dataset and  2024 race result
        List<Driver> driverList = Driver.get2024DriverList();
        List<RaceResult> raceResultList = RaceResult.get2024RaceResults();

        //Formatted Console Output Using stream(), forEach(), filter()
        System.out.println("-------------------------------- 2024 F1 Drivers --------------------------------");
        System.out.printf("%-5s | %-25s | %-35s\n","ID","Name","Team");
        System.out.println("---------------------------------------------------------------------------------");
        driverList.forEach(driver -> System.out.printf("%-5s | %-25s | %-35s\n",driver.id(),driver.name(),driver.team()));


        //將Driver類別的id, name設成key,value存進idToNameMap內
        Map<String, String> idToNameMap = driverList.stream()
                .collect(Collectors.toMap(Driver::id,Driver::name));

        Set<String> ferrariIds = driverList.stream()
                .filter(driver -> driver.team().equals("Ferrari"))
                .map(Driver::id)
                .collect(Collectors.toSet());

        List<String> podiumPosition =List.of("1","2","3");

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("            The chance of Ferrari Driver standing on the podium");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("%-5s | %-25s | %-15s | %-10s | %-15s\n","ID","Driver_Name","Total_Race","Podium","Podium_Rate");
        System.out.println("---------------------------------------------------------------------------------");

        ferrariIds.forEach(id -> {
            String name = idToNameMap.getOrDefault(id,"Unknown");
            List<RaceResult> personalRaceResult = raceResultList.stream()
                    .filter(raceResult -> raceResult.id().equals(id))
                    .toList();
            int totalRace = personalRaceResult.size();
            long podiums = personalRaceResult.stream()
                    .filter(raceResult -> podiumPosition.contains(raceResult.position()))
                    .count();
            double podiumRate = (totalRace > 0) ? (double) podiums / totalRace * 100 : 0.0;
            System.out.printf("%-5s | %-25s | %-15d | %-10d | %-6.2f%%\n", id,name,totalRace,podiums,podiumRate);
        });

    }

}
