package model;

import java.util.List;

public record Driver(String id, String name, String team) {
    public static List<Driver> get2024DriverList() {
        return List.of(
                new Driver("1","Max  Verstappen","Red Bull Racing"),
                new Driver("16","Charles  Leclerc","Ferrari"),
                new Driver("4","Lando  Norris","McLaren"),
                new Driver("55","Carlos  Sainz","Ferrari"),
                new Driver("11","Sergio  Perez","Red Bull Racing"),
                new Driver("81","Oscar  Piastri","McLaren"),
                new Driver("63","George  Russell","Mercedes"),
                new Driver("44","Lewis  Hamilton","Mercedes"),
                new Driver("14","Fernando  Alonso","Aston Martin Aramco"),
                new Driver("22","Yuki  Tsunoda","RB"),
                new Driver("18","Lance  Stroll","Aston Martin Aramco"),
                new Driver("38","Oliver  Bearman","Ferrari"),
                new Driver("27","Nico  Hulkenberg","Haas"),
                new Driver("3","Daniel  Ricciardo","RB"),
                new Driver("23","Alexander  Albon","Williams"),
                new Driver("31","Esteban  Ocon","Alpine"),
                new Driver("20","Kevin  Magnussen","Haas"),
                new Driver("10","Pierre  Gasly","Alpine"),
                new Driver("24","Zhou  Guanyu","Kick Sauber"),
                new Driver("77","Valtteri  Bottas","Kick Sauber"),
                new Driver("2","Logan  Sargeant","Williams")
        );
    }
}

