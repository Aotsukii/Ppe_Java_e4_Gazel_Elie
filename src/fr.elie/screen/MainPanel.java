package fr.elie.screen;

import fr.elie.screen.fields.PrimaryButton;


import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;

public class MainPanel extends JPanel {

    private MainScreen mainScreen;

    public MainPanel(MainScreen mainScreen) {
        this.setUI(new BasicPanelUI());

        this.mainScreen = mainScreen;

        components();
    }

    private void components(){
        Label welcome_message = new Label();
        welcome_message.setText("Panel de gestion de l'école de Barbe Grise");
        welcome_message.setFont(new Font("SansSerif", Font.PLAIN, 17));
        welcome_message.setAlignment(Label.CENTER);
        add(welcome_message);

        PrimaryButton gest_elev = new PrimaryButton("Gestion des élèves");
    }

}

