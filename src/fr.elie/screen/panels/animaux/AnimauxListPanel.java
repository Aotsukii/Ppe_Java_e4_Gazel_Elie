package fr.elie.screen.panels.animaux;

import fr.elie.Application;
import fr.elie.screen.fields.tables.AnimauxTable;

import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;

/**
 * Class créée le 12/03/2019 à 12:19
 * par Jullian Dorian
 */
public class AnimauxListPanel extends JPanel{

    public AnimauxListPanel(JFrame frame) {
        this.setUI(new BasicPanelUI());
        this.setLayout(new BorderLayout());

        AnimauxTable table= new AnimauxTable(Application.toTab(Application.getAnimalList().values()));

        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setPreferredSize(new Dimension(450, 350));
        add(jScrollPane, BorderLayout.NORTH);

        frame.pack();
    }

}