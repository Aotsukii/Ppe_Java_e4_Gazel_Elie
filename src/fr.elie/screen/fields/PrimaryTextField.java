package fr.elie.screen.fields;

import javax.swing.*;
import java.awt.*;

public class PrimaryTextField extends JTextField {

    public PrimaryTextField() {
        this.setFont(new Font("SansSerif", Font.PLAIN, 11));
        this.setPreferredSize(new Dimension(200, 15));
    }
}