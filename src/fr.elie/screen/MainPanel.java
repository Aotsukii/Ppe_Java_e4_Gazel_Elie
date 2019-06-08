package fr.elie.screen;

import fr.elie.screen.fields.PrimaryButton;
import fr.elie.screen.panels.animaux.AnimauxMainPanel;

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
        welcome_message.setText("Gestion du refuge du Languedoc");
        welcome_message.setFont(new Font("SansSerif", Font.PLAIN, 17));
        welcome_message.setAlignment(Label.CENTER);
        add(welcome_message);

        PrimaryButton gest_animaux = new PrimaryButton("Gestion des animaux");
        gest_animaux.addActionListener(e -> {
            AnimauxMainPanel animauxMainPanel = new AnimauxMainPanel(mainScreen);
            mainScreen.changePanel(animauxMainPanel);
        });
        add(gest_animaux);
    }

}

