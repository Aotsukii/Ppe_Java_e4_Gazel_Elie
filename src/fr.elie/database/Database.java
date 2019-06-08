package fr.elie.database;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class Database {
    public static final String DRIVER_MYSQL = "jdbc:mysql";
    public static final String DRIVER_SQLSERVER = "jdbc:sqlserver";
    private final String driver;
    private final String host;
    private final String database;
    private final int port;
    private final String user;
    private final String password;

    private Connection connection = null;

    public Database(String driver, String host, int port, String database, String user, String password) {
        this.driver = driver;
        this.host = host;
        this.port = port;
        this. database = database;
        this.user = user;
        this.password = password;
    }

    public void connectDb(){
        try{
            switch(this.driver){
                case DRIVER_MYSQL:
                    System.out.println("DRIVER MYSQL DETECTE");
                    Class.forName("com.mysql.jdbc.Driver");
                    this.connection = DriverManager.getConnection(this.driver+"://"+this.host+":"+this.port+"/"+this.database+"?charset=utf8&useSSL=false",this.user,this.password);
                    break;
                case DRIVER_SQLSERVER:
                    System.out.println("DRIVER SQLSERVER DETECTE");
                    String uri = this.driver+"://"+this.host+":"+port+";databaseName="+this.database+";instanceNameDESKTOP-JRU2AKK;integratedSecurity=true;";
                    this.connection = DriverManager.getConnection(uri);
                    break;
            }
            System.out.println("Connexion à la base de données effectuée");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void disconnectDb(){
        try {
            if(!connection.isClosed()){
                this.connection.close();
                this.connection=null;
                System.out.println("Bdd déconnectée");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection(){return connection;}

    public boolean isConnected() { return this.connection != null; }
}
