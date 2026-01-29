package controller;

import model.Driver;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //setting hardcode of f1 driver 2024 dataset
        List<Driver> driverList = new ArrayList<>();
        Driver d1 = new Driver("1","Max  Verstappen","Red Bull Racing Honda RBPT");
        Driver d2 = new Driver("16","Charles  Leclerc","Ferrari");
        Driver d3 = new Driver("4","Lando  Norris","McLaren Mercedes");
        Driver d4 = new Driver("55","Carlos  Sainz","Ferrari");
        Driver d5 = new Driver("11","Sergio  Perez","Red Bull Racing Honda RBPT");
        Driver d6 = new Driver("81","Oscar  Piastri","McLaren Mercedes");
        Driver d7 = new Driver("63","George  Russell","Mercedes");
        Driver d8 = new Driver("44","Lewis  Hamilton","Mercedes");
        Driver d9 = new Driver("14","Fernando  Alonso","Aston Martin Aramco Mercedes");
        Driver d10 = new Driver("22","Yuki  Tsunoda","RB Honda RBPT");
        Driver d11 = new Driver("18","Lance  Stroll","Aston Martin Aramco Mercedes");
        Driver d12 = new Driver("38","Oliver  Bearman","Ferrari");
        Driver d13 = new Driver("27","Nico  Hulkenberg","Haas Ferrari");
        Driver d14 = new Driver("3","Daniel  Ricciardo","RB Honda RBPT");
        Driver d15 = new Driver("23","Alexander  Albon","Williams Mercedes");
        Driver d16 = new Driver("31","Esteban  Ocon","Alpine Renault");
        Driver d17 = new Driver("20","Kevin  Magnussen","Haas Ferrari");
        Driver d18 = new Driver("10","Pierre  Gasly","Alpine Renault");
        Driver d19 = new Driver("24","Zhou  Guanyu","Kick Sauber Ferrari");
        Driver d20 = new Driver("77","Valtteri  Bottas","Kick Sauber Ferrari");
        Driver d21 = new Driver("2","Logan  Sargeant","Williams Mercedes");
        driverList.add(d1);
        driverList.add(d2);
        driverList.add(d3);
        driverList.add(d4);
        driverList.add(d5);
        driverList.add(d6);
        driverList.add(d7);
        driverList.add(d8);
        driverList.add(d9);
        driverList.add(d10);
        driverList.add(d11);
        driverList.add(d12);
        driverList.add(d13);
        driverList.add(d14);
        driverList.add(d15);
        driverList.add(d16);
        driverList.add(d17);
        driverList.add(d18);
        driverList.add(d19);
        driverList.add(d20);
        driverList.add(d21);

        System.out.println(driverList);
    }
}
