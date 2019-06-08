package fr.elie.screen.fields;

import javax.swing.*;
import java.awt.*;

public class PrimaryButton extends JButton {

    public PrimaryButton(String text) {
        this.setText(text);
        this.setFont(new Font("SansSerif", Font.PLAIN, 12));
        this.setPreferredSize(new Dimension(200, 35));
    }

}
