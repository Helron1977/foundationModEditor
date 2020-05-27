package fr.foundation.modwizard.controller;

import fr.foundation.modwizard.model.Building;
import fr.foundation.modwizard.model.Model;
import fr.foundation.modwizard.view.BuildingForm;
import fr.foundation.modwizard.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuildingController extends Controller {
    private BuildingForm buildingForm;
    private Building building;

    public BuildingController(BuildingForm buildingForm, Building building) {
        this.buildingForm = buildingForm;
        this.building = building;
        initView(buildingForm);
        initController(buildingForm,building);
    }

    @Override
    public void initController(View view, Model model) {
        buildingForm.getNextButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                building.setId(buildingForm.getOrderId().getText());


                building.generateCode();
                closeFrame(buildingForm.getBuildingform());
            }
        });
    }

}
