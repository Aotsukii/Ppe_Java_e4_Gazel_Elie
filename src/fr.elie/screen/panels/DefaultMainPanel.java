package fr.elie.screen.panels;

import fr.elie.screen.MainPanel;
import fr.elie.screen.MainScreen;
import fr.elie.screen.fields.PrimaryButton;

import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;

/**
 * Class créée le 12/03/2019 à 11:24
 * par Jullian Dorian
 */
public class DefaultMainPanel extends JPanel {

    protected MainScreen mainScreen;
    protected PrimaryButton back;
    protected Label title;

    public DefaultMainPanel(String title, MainScreen mainScreen){
        this.setUI(new BasicPanelUI());

        this.mainScreen = mainScreen;

        this.back = new PrimaryButton("Retour en arrière");
        this.back.addActionListener(e -> {
            mainScreen.changePanel(new MainPanel(mainScreen));
        });

        this.title = new Label(title);
        this.title.setFont(new Font("SansSerif", Font.PLAIN, 17));
        this.title.setAlignment(Label.CENTER);

        this.add(this.title); // titre en haut
    }

}