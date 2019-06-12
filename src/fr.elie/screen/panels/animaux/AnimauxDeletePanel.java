package fr.elie.screen.panels.animaux;

import fr.elie.Application;
import fr.elie.content.Animal;
import fr.elie.screen.fields.PrimaryButton;
import fr.elie.screen.fields.PrimaryTextField;
import fr.elie.screen.fields.tables.AnimauxTable;


import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;


public class AnimauxDeletePanel extends JPanel{
    Date date = new Date();

    public AnimauxDeletePanel(JFrame frame) {
        this.setUI(new BasicPanelUI());
        this.setLayout(new BorderLayout());
        AnimauxTable table= new AnimauxTable(Application.toTab(Application.getAnimalList().values()));
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setPreferredSize(new Dimension(450, 315));
        add(jScrollPane, BorderLayout.NORTH);
        PrimaryButton delete = new PrimaryButton("Supprimer");
        add(delete);
    }
}