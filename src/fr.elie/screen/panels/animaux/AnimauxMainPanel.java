package fr.elie.screen.panels.animaux;

import fr.elie.screen.MainScreen;
import fr.elie.screen.fields.PrimaryButton;
import fr.elie.screen.panels.DefaultMainPanel;

import javax.swing.*;
import java.awt.event.ActionListener;


public class AnimauxMainPanel extends DefaultMainPanel {

    protected JFrame currentFrame;

    public AnimauxMainPanel(MainScreen mainScreen){
        super("Gestion des animaux", mainScreen);


        PrimaryButton liste = new PrimaryButton("Liste des animaux");
        liste.addActionListener(e ->{
            if(currentFrame == null) {
                this.currentFrame = new AnimauxListFrame(this);
            }
        });
        add(liste);

        PrimaryButton create = new PrimaryButton("Ajouter un animal");
        create.addActionListener(e ->{
            if(currentFrame == null) {
                this.currentFrame = new AnimauxCreateFrame(this);
            }
        });
        add(create);

        PrimaryButton delete = new PrimaryButton("Supprimer un animal");
        delete.addActionListener(e ->{
            if(currentFrame == null) {
                this.currentFrame = new AnimauxDeleteFrame(this);
            }
        });
        add(delete);

        final ActionListener backAction = this.back.getActionListeners()[0];
        this.back.removeActionListener(backAction);
        this.back.addActionListener(e -> {
            if(currentFrame == null) {
                backAction.actionPerformed(e); //on récupère le bouton qui reviens en arrière
            }
        });
        add(this.back);

        this.setVisible(true);
    }


}