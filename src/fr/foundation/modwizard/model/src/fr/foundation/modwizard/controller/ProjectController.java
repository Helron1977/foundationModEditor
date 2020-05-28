package fr.foundation.modwizard.controller;


import fr.foundation.modwizard.model.Building;
import fr.foundation.modwizard.model.Model;
import fr.foundation.modwizard.model.Project;
import fr.foundation.modwizard.view.BuildingForm;
import fr.foundation.modwizard.view.ProjectForm;
import fr.foundation.modwizard.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ProjectController extends Controller {
    private ProjectForm projectForm;
    private Project project;

    public ProjectController(ProjectForm projectForm, Project project) {
        this.projectForm = projectForm;
        this.project = project;
        initView(projectForm);
        initController(projectForm,project);
    }

    @Override
    public void initController(View view, Model model) {
        projectForm.getNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeFrame(projectForm.getProjectForm());
                project.setFbxName(projectForm.getFbxNameField().getText());
                project.setModName(projectForm.getProjectField().getText());
                //Open next Form


                //Add the method to generate the code
                Building model02 = new Building();
                BuildingForm view02 = new BuildingForm();
                BuildingController controller02 = new BuildingController(view02, model02);

            }
        });

    }


}

