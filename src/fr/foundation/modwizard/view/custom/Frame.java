package fr.foundation.modwizard.view.custom;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame(JPanel panelToDisplay){
        //get screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;

        //set frame size 1/2 screenSize;
        setSize(width/2-panelToDisplay.getWidth(),height/2-panelToDisplay.getHeight());
        setContentPane(panelToDisplay);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
}
