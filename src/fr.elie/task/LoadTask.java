package fr.elie.task;

import fr.elie.content.*;
import fr.elie.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LoadTask implements Runnable {

    private final Database database;

    private Map<Integer, Animal> AnimalList = new HashMap<>();
    private Map<Integer, Benevole> BenevoleList = new HashMap<>();
    private Map<Integer, Collecte> CollecteList = new HashMap<>();

    private Map<Integer, Fa> FaList = new HashMap<>();
    private Map<Integer, Membre> MembreList = new HashMap<>();
    private Map<Integer, Race> RaceList = new HashMap<>();

    public LoadTask(Database database) {
        this.database = database;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        //connection
        database.connectDb();

        if(!database.isConnected()) return;

        Connection connection = database.getConnection();

        try {
            //Chargement des eleves
            final PreparedStatement statementAnimaux = connection.prepareStatement("SELECT e.* FROM dbo.ANIMAL");
            ResultSet resultSet = statementAnimaux.executeQuery();

            while(resultSet.next()) {
                Animal animal = new Animal(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getBoolean(6),
                        resultSet.getBoolean(7),
                        resultSet.getBoolean(8),
                        resultSet.getDate(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getString(12),
                        resultSet.getString(13)
                );
                this.AnimalList.put(animal.getId(), animal);
            }
            statementAnimaux.close();
            /* ---- */
            System.out.println("Aucune erreur n'a été trouvé lors de la récupération des données.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //deconnexion
        database.disconnectDb();
    }

    public Map<Integer, Animal> getAnimalList() {
        return AnimalList;
    }

    public Map<Integer, Benevole> getBenevoleList() {
        return BenevoleList;
    }

    public Map<Integer, Collecte> getCollecteList() { return CollecteList; }

    public Map<Integer, Fa> getFaList() {
        return FaList;
    }

    public Map<Integer, Membre> getMembreList() {
        return MembreList;
    }

    public Map<Integer, Race> getRaceList() {
        return RaceList;
    }

}
