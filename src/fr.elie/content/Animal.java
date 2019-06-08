package fr.elie.content;

import fr.elie.Application;
import fr.elie.database.Database;
//import fr.elie.database.Database;

import java.sql.Statement;
import java.util.*;

public class Animal {

    private final Database database = Application.getDatabase();
    private int id_animal;
    private String nom_animal;
    private int age_animal;
    private String sexe_animal;
    private String desc_animal;
    private Boolean ok_chien;
    private Boolean ok_chat;
    private Boolean ok_enfant;
    private Date date_creation;
    private String race_animal;
    private String pelage_animal;
    private String besoin_traitement;
    private Boolean est_chat;

    public int getId(){ return this.id_animal; }
    public String getNom(){ return this.nom_animal;}
    public int getAge(){ return this.age_animal; }
    public String getSexe(){ return this.sexe_animal; }
    public String getDesc(){ return this.desc_animal; }
    public Boolean getOkChien() { if(this.ok_chien){return true;} else { return false;} }
    public Boolean getOkChat() { if(this.ok_chat){return true;} else { return false;} }
    public Boolean getOkEnfant() { if(this.ok_enfant){return true;} else { return false;} }
    public Date getDateCreation(){ return this.date_creation; }
    public String getRace(){ return this.race_animal; }
    public String getPelage(){ return this.pelage_animal; }
    public String getTraitement(){return besoin_traitement;}
    public String getType(){ if(est_chat){return "chat";} else { return "chien";} }



}
