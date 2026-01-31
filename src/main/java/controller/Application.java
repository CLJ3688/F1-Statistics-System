package controller;

import model.Driver;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        //setting hardcode of f1 driver 2024 dataset
        List<Driver> driverList = Driver.get2024DriverList();


        //Formatted Console Output Using stream(), forEach(), filter()
        System.out.println("--------------- 2024 F1 Drivers ---------------");
        System.out.printf("%-5s | %-25s | %-35s\n","ID","Name","Team");
        System.out.println("-----------------------------------------------");
        driverList.forEach(driver -> System.out.printf("%-5s | %-25s | %-25s\n",driver.id(),driver.name(),driver.team()));

        long ferrariCount = driverList.stream().filter( driver -> driver.team().equals("Ferrari")).count();
        System.out.println("\nFerrari Driver : " + ferrariCount + "\n");
        driverList.stream()
                .filter(driver -> driver.team().equals("Ferrari"))
                .forEach(driver -> System.out.printf("%-5s | %-25s\n",driver.id() , driver.name()));
    }

}
