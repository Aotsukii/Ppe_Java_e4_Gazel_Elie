package fr.elie.screen.panels.animaux;

import fr.elie.Application;
import fr.elie.content.Animal;
import fr.elie.screen.fields.PrimaryButton;
import fr.elie.screen.fields.PrimaryTextField;



import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;


public class AnimauxCreatePanel extends JPanel{
    Date date = new Date();

    public AnimauxCreatePanel(JFrame frame) {
        this.setUI(new BasicPanelUI());
        this.setLayout(new GridLayout(0, 2, 10, 1));

        Label name = new Label("Nom de l'animal*");
        PrimaryTextField name_field = new PrimaryTextField();
        Label age = new Label("Age*");
        PrimaryTextField age_field = new PrimaryTextField();
        Label desc = new Label("Description*");
        PrimaryTextField desc_field = new PrimaryTextField();

        this.add(name);
        this.add(name_field);
        this.add(age);
        this.add(age_field);
        this.add(desc);
        this.add(desc_field);


        Label obg = new Label("* : Champs obligatoire");
        obg.setFont(new Font("SansSerif", Font.PLAIN, 9));
        this.add(obg);
        this.add(new Label());

        PrimaryButton confirm = new PrimaryButton("Ajouter un animal");
        confirm.addActionListener(e -> {

            final String nameValue = name_field.getText();
            final String ageValue = age_field.getText();
            final String descValue = desc_field.getText();


            boolean canReg = true;

            if(nameValue.isEmpty() || !nameValue.matches("[a-zA-Z]+")) {
                errorField(name_field);
                canReg = false;
            } else
                resetField(name_field);

            if(ageValue.isEmpty() || !ageValue.matches("[0-9]{2}")) {
                errorField(age_field);
                canReg = false;
            }else
                resetField(age_field);

            if(descValue.isEmpty() || !descValue.matches("[a-zA-Z]{300}")) {
                errorField(desc_field);
                canReg = false;
            }else
                resetField(desc_field);
            if(canReg) {
                final Animal animal = new Animal(0, nameValue, ageValue, descValue,"zzz",false,true,false, date,"test","test","ui",false);

                boolean addOptions = true;

                if(addOptions) {
                    if (animal.register()) {
                        Application.getAnimalList().put(animal.getId(), animal);
                        System.out.println("Bien enregistré");
                        //Fermer la fenetre
                        frame.dispose();
                    }
                } else {
                    System.out.println("Impossible d'enregistrer car email ou telephone erroné");
                }
            }

        });

        this.add(confirm);

    }

    private void errorField(JComponent label) {
        label.setBackground(new Color(255, 74, 76));
    }

    private void resetField(JComponent label) {
        label.setBackground(new Color(255,255,255));
    }


}