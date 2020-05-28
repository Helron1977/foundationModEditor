package fr.foundation.modwizard;

import fr.foundation.modwizard.controller.Controller;
import fr.foundation.modwizard.controller.ProjectController;
import fr.foundation.modwizard.model.Project;
import fr.foundation.modwizard.view.ProjectForm;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, fall back to cross-platform
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                // not worth my time
            }
        }



        //Create and launch mcv project
        Project model = new Project("test", "fbx");
        ProjectForm view = new ProjectForm();
        ProjectController controller = new ProjectController(view, model);

        //create and launch mcv building
    }

}
