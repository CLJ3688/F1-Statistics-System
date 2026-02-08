package controller;

import Service.StatisticsService;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        StatisticsService statisticsService = new StatisticsService();
        ResultPrinter resultPrinter = new ResultPrinter();

        //Print all driver
        resultPrinter.printAllDriver(statisticsService.getAllDrivers());

        //Print 2023 raceResult
        resultPrinter.printRaceResult(statisticsService.getRaceResult(),"2023");



        //Get specific team driver stand on podium data list
        //List<StatisticsService.DriverPodiumStats> driverPodiumStatsList = statisticsService.getDriverPodiumStats("Red Bull Racing");

        //resultPrinter.printDriverPodiumStats(driverPodiumStatsList,"Red Bull Racing");
    }

}
