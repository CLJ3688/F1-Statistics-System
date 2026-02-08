package controller;

import Service.StatisticsService;
import model.Driver;
import model.RaceResult;

import java.util.Comparator;
import java.util.List;

public class ResultPrinter {
    public void printAllDriver(List<Driver> driverList) {
        System.out.println("-------------------------------- F1 Drivers --------------------------------");
        System.out.printf("%-5s | %-25s\n","ID","Name");
        System.out.println("----------------------------------------------------------------------------");
        driverList.forEach(driver -> System.out.printf("%-5s | %-25s\n",driver.driverId(),driver.name()));
    }

    public void printRaceResult(List<RaceResult> raceResultList,String year) {
        System.out.println("-------------------------------- RaceResult of " + year + " --------------------------------");
        System.out.printf("%-10s | %-10s | %-10s | %-10s\n","driverID","teamId","position","points");
        System.out.println("------------------------------------------------------------------------------------");
        raceResultList.stream()
                .filter(raceResult -> raceResult.year().equals(year))
                .sorted((Comparator.comparingInt((RaceResult raceResult) -> Integer.parseInt(raceResult.teamId()))
                        .thenComparing(raceResult -> Integer.parseInt(raceResult.driverId()) )))
                .forEach(raceResult -> System.out.printf("%-10s | %-10s | %-10s | %-10d\n"
                                                                        ,raceResult.driverId()
                                                                        ,raceResult.teamId()
                                                                        ,raceResult.position()
                                                                        ,raceResult.points()));
    }

    public void printDriverPodiumStats(List<StatisticsService.DriverPodiumStats> driverPodiumStatsList, String teamName) {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("            The chance of " + teamName + " Driver standing on the podium");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("%-5s | %-25s | %-15s | %-10s | %-15s\n","ID","Driver_Name","Total_Race","Podium","Podium_Rate");
        System.out.println("---------------------------------------------------------------------------------");

        driverPodiumStatsList.forEach(driverPodiumStats ->
                System.out.printf("%-5s | %-25s | %-15d | %-10d | %-6.2f%%\n",
                        driverPodiumStats.id(),
                        driverPodiumStats.name(),
                        driverPodiumStats.totalRaces(),
                        driverPodiumStats.podiumCounts(),
                        driverPodiumStats.rate()
                ));
    }
}
