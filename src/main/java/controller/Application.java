package controller;

import Service.StatisticsService;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        StatisticsService statisticsService = new StatisticsService();
        ResultPrinter resultPrinter = new ResultPrinter();

        //Print all driver (2024)
        resultPrinter.printAllDriver(statisticsService.getAllDrivers());

        //Get specific team driver stand on podium data list
        List<StatisticsService.DriverPodiumStats> driverPodiumStatsList = statisticsService.getDriverPodiumStats("Red Bull Racing");

        resultPrinter.printDriverPodiumStats(driverPodiumStatsList,"Red Bull Racing");
    }

}
