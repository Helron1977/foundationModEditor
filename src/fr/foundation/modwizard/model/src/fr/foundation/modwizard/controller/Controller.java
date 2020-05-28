package fr.foundation.modwizard.controller;

import fr.foundation.modwizard.model.Building;
import fr.foundation.modwizard.model.Model;
import fr.foundation.modwizard.view.View;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;


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
