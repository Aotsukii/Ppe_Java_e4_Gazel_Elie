package fr.elie;

import fr.elie.content.*;
//import fr.elie.database.Database;
import fr.elie.screen.MainScreen;
import fr.elie.task.LoadTask;

import java.io.File;
import java.util.*;

public class Application {
    private final Scanner scanner;

    private final MainScreen mainScreen;
    private static Database database;

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

        //On enregistre la base de données
        System.out.println("Préparation de la base de données...");
        //database = new Database(Database.DRIVER_MYSQL, "localhost", 3306, "ppe_lourd", "root", "");
        database = new Database(Database.DRIVER_SQLSERVER, "localhost", 1433, "ppe_lourd", "IFU-NC4OKL4\\Arkas", "");
        System.out.println("Base de données : OK");

        //Lancement de la fenetre
        System.out.println("Ouverture de la fenêtre...");
        this.mainScreen = new MainScreen();
        System.out.println("Ouverture : OK");

        System.out.println("Chargement des données en arrière plan...");
        LoadTask loadTask = new LoadTask(database);
        loadTask.run();

        AnimalList = loadTask.getAnimalList();
        BenevoleList = loadTask.getBenevoleList();
        FaList = loadTask.getFaList();
        CollecteList = loadTask.getCollecteList();
        MembreList = loadTask.getMembreList();
        RaceList = loadTask.getRaceList();
        classeList = loadTask.getClasseList();

        System.out.println("Chargement : OK");

    }

    public static Database getDatabase(){
        return database;
    }

    public static Map<Integer, Eleve> getEleveList() {
        return eleveList;
    }

    public static Map<Integer, Professeur> getProfesseurList() {
        return professeurList;
    }

    public static Map<Integer, Parent> getParentList() {
        return parentList;
    }

    public static Map<Integer, Matiere> getMatiereList() {
        return matiereList;
    }

    public static Map<Integer, Classe> getClasseList() {
        return classeList;
    }

    public static Map<Integer, Salle> getSalleList() {
        return salleList;
    }

    public static Map<Integer, Seance> getSeanceList() {
        return seanceList;
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

