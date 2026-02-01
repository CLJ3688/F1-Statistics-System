package controller;

import Service.StatisticsService;
import model.Driver;

import java.util.List;

public class ResultPrinter {
    public void printAllDriver(List<Driver> driverList) {
        System.out.println("-------------------------------- 2024 F1 Drivers --------------------------------");
        System.out.printf("%-5s | %-25s | %-35s\n","ID","Name","Team");
        System.out.println("---------------------------------------------------------------------------------");
        driverList.forEach(driver -> System.out.printf("%-5s | %-25s | %-35s\n",driver.id(),driver.name(),driver.team()));
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
