package fr.elie.content;

import java.util.*;
import fr.elie.Application;
import fr.elie.database.Database;

import java.sql.Statement;

public class Animal {

    protected final Database database = Application.getDatabase();
    private int id_animal;
    private String nom_animal;
    private String age_animal;
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

    public Animal(int id_animal, String nom_animal, String age_animal, String sexe_animal, String desc_animal, Boolean ok_chien, Boolean ok_chat, Boolean ok_enfant, Date date_creation, String race_animal, String pelage_animal,
                  String besoin_traitement, Boolean est_chat){
        this.id_animal=id_animal;
        this.nom_animal=nom_animal;
        this.age_animal=age_animal;
        this.sexe_animal=sexe_animal;
        this.desc_animal=desc_animal;
        this.ok_chien=ok_chien;
        this.ok_chat=ok_chat;
        this.ok_enfant=ok_enfant;
        this.date_creation=date_creation;
        this.race_animal=race_animal;
        this.pelage_animal=pelage_animal;
        this.besoin_traitement=besoin_traitement;
        this.est_chat=est_chat;
    };


    public int getId(){ return this.id_animal; }
    public String getNom(){ return this.nom_animal;}
    public String getAge(){ return this.age_animal; }
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

    public boolean register(){
        boolean createEntite = register();
        final Map<String,Object> keys = new HashMap<>();
        keys.put("id_animal", getId());
        boolean createAnimal = this.database.insert("dbo.ANIMAL", keys) == 1;
        return createAnimal && createEntite;
    }
}
