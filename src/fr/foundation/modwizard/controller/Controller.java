package fr.foundation.modwizard.controller;

import fr.foundation.modwizard.model.Model;
import fr.foundation.modwizard.view.View;

import javax.swing.*;



public abstract class Controller {

    boolean isClose = false;


    public abstract void initController(View view, Model model);

    public void initView(View view){
        view.display();
    }


    public  void closeFrame(JComponent component) {
        SwingUtilities.windowForComponent(component).dispose();
        isClose = true;
    }

}
