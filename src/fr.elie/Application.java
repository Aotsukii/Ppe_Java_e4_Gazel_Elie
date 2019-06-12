package fr.elie;

import fr.elie.content.*;
import fr.elie.database.Database;
import fr.elie.screen.MainScreen;
import fr.elie.task.LoadTask;

import java.io.File;
import java.util.*;

public class Application {
    private final Scanner scanner;
    private static Database database;
    private final MainScreen mainScreen;

    private static Map<Integer, Animal> AnimalList;
    private static Map<Integer, Benevole> BenevoleList;
    private static Map<Integer, Fa> FaList;

    private static Map<Integer, Collecte> CollecteList;
    private static Map<Integer, Membre> MembreList;
    private static Map<Integer, Race> RaceList;

    /**
     * Launch the application
     * @param args
     */
    public static void main(String[] args) {
        new Application(args);
    }

    /**
     * Constructor
     * @param args
     */
    private Application(String[] args){

        this.scanner = new Scanner(System.in);
        database = new Database(Database.DRIVER_SQLSERVER, "localhost", 1433, "ppe_lourd_e4", "DESKTOP-JRU2AKK\\Buck", "");
        this.mainScreen = new MainScreen();
        LoadTask loadTask = new LoadTask(database);
        loadTask.run();

        AnimalList = loadTask.getAnimalList();
        BenevoleList = loadTask.getBenevoleList();
        FaList = loadTask.getFaList();
        CollecteList = loadTask.getCollecteList();
        MembreList = loadTask.getMembreList();
        RaceList = loadTask.getRaceList();
        System.out.println("ok load");

    }
    public static Database getDatabase(){
        return database;
    }

    public static Map<Integer, Animal> getAnimalList() {
        return AnimalList;
    }

    public static Map<Integer, Benevole> getBenevoleList() {
        return BenevoleList;
    }

    public static Map<Integer, Fa> getFaList() {
        return FaList;
    }

    public static Map<Integer, Collecte> getCollecteList() {
        return CollecteList;
    }

    public static Map<Integer, Membre> getMembreList() {
        return MembreList;
    }

    public static Map<Integer, Race> getRaceList() {
        return RaceList;
    }

    public static Object[] toTab(Collection<?> collection){

        Object[] objects = new Object[collection.size()];

        int index = 0;
        for(Object o : collection) {
            objects[index++] = o;
        }

        return objects;
    }
}

