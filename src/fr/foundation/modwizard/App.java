package fr.foundation.modwizard;

import fr.foundation.modwizard.controller.Controller;
import fr.foundation.modwizard.controller.ProjectController;
import fr.foundation.modwizard.model.Project;
import fr.foundation.modwizard.view.ProjectForm;

public class App {

    public static void main(String[] args) {
        //Create and launch mcv project
        Project model = new Project("test", "fbx");
        ProjectForm view = new ProjectForm();
        ProjectController controller = new ProjectController(view, model);

        //create and launch mcv building
    }

}
