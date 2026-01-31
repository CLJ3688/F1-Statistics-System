package model;

import java.util.List;

public record Driver(String id, String name, String team) {
    public static List<Driver> get2024DriverList() {
        return List.of(
                new Driver("1","Max  Verstappen","Red Bull Racing Honda RBPT"),
                new Driver("16","Charles  Leclerc","Ferrari"),
                new Driver("4","Lando  Norris","McLaren Mercedes"),
                new Driver("55","Carlos  Sainz","Ferrari"),
                new Driver("11","Sergio  Perez","Red Bull Racing Honda RBPT"),
                new Driver("81","Oscar  Piastri","McLaren Mercedes"),
                new Driver("63","George  Russell","Mercedes"),
                new Driver("44","Lewis  Hamilton","Mercedes"),
                new Driver("14","Fernando  Alonso","Aston Martin Aramco Mercedes"),
                new Driver("22","Yuki  Tsunoda","RB Honda RBPT"),
                new Driver("18","Lance  Stroll","Aston Martin Aramco Mercedes"),
                new Driver("38","Oliver  Bearman","Ferrari"),
                new Driver("27","Nico  Hulkenberg","Haas Ferrari"),
                new Driver("3","Daniel  Ricciardo","RB Honda RBPT"),
                new Driver("23","Alexander  Albon","Williams Mercedes"),
                new Driver("31","Esteban  Ocon","Alpine Renault"),
                new Driver("20","Kevin  Magnussen","Haas Ferrari"),
                new Driver("10","Pierre  Gasly","Alpine Renault"),
                new Driver("24","Zhou  Guanyu","Kick Sauber Ferrari"),
                new Driver("77","Valtteri  Bottas","Kick Sauber Ferrari"),
                new Driver("2","Logan  Sargeant","Williams Mercedes")
        );
    }
}

