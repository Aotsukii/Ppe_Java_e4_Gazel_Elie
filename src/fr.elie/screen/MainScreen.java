package fr.elie.screen;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JFrame {

    private final int width = 1080 / 3;
    private final int height = 820 / 2;

    public MainScreen(){
        this.setTitle("Refuge du Languedoc");
        this.setIconImage(null);

        this.setSize(width, height);
        this.setPreferredSize(new Dimension(width, height));
        this.setResizable(true);
        this.setLocationRelativeTo(null);

        add(new MainPanel(this));


        this.setVisible(true);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Change l'affichage de la frame
     * @param jPanel
     */
    public void changePanel(JPanel jPanel){
        getContentPane().removeAll();
        setContentPane(jPanel);
        validate();
    }

}
