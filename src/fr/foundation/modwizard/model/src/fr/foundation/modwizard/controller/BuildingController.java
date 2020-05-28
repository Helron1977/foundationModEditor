package fr.foundation.modwizard.controller;

import fr.foundation.modwizard.model.Building;
import fr.foundation.modwizard.model.BuildingPartSet;
import fr.foundation.modwizard.model.Model;
import fr.foundation.modwizard.model.VillagerStatusQuantityPair;
import fr.foundation.modwizard.view.BuildingForm;
import fr.foundation.modwizard.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

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
                collectData();
                try {
                    buildingForm.getCodePane().setText(Building.generateCode(building));
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }


                //closeFrame(buildingForm.getBuildingform());
            }

            private void collectData() {
                building.setDataType("BUILDING");
                //-------------------------------------------------------
                building.setId(buildingForm.getOrderId().getText());
                //-------------------------------------------------------
                building.setName(buildingForm.getName().getText());
                //-------------------------------------------------------
                building.setDescription(buildingForm.getDescription().getText());
                //-------------------------------------------------------
                building.setBuildingType(Objects.requireNonNull(buildingForm.buildingTypeComboBox.getSelectedItem()).toString());
                //-------------------------------------------------------
                ArrayList<BuildingPartSet> collectedBuildingSubPanel = collectBuildingPartSetSubFormData();
                building.setBuildingPartSet(collectedBuildingSubPanel);
                //-------------------------------------------------------
                ArrayList<VillagerStatusQuantityPair> collectedVillagerSubPanelDatas = collectVillagerRequiredSubformData();
                building.setVillagerRequired(collectedVillagerSubPanelDatas);
                //-------------------------------------------------------
                building.setDesirabilityLayer(Objects.requireNonNull(buildingForm.getDesirabilityComboBox().getSelectedItem()).toString());
                //-------------------------------------------------------
                building.setManuallyUnlocked(buildingForm.getIsManuallyUnlockedBox().isSelected());
                //-------------------------------------------------------
                building.setDestructible(buildingForm.getIsDestructibleBox().isSelected());
                //-------------------------------------------------------
                building.setEditable(buildingForm.getIsEditableBox().isSelected());
                //-------------------------------------------------------
                building.setHidden(buildingForm.getIsHiddenBox().isSelected());
                //-------------------------------------------------------
                building.setClearTrees(buildingForm.getIsHiddenBox().isSelected());

            }

            /**
             * to fill the field ArrayList<BuildingPartSet> of the API Class Building
             * Create an BuildingPartSet
             * Arg 1 : Hard coded .. only one Set at the moment.
             * Arg 2 : Collect a list from BuildingPart SubPanel.
             * Create the list of BuildingPartSet
             * @return ArrayList<BuildingPartSet>
             */
            private ArrayList<BuildingPartSet> collectBuildingPartSetSubFormData() {
                ArrayList<String> buildingPartList = buildingForm.getSubpanelBuildingpart().getJComponentToStringList();
                BuildingPartSet buildingPartSet = new BuildingPartSet("SET1",buildingPartList);
                ArrayList<BuildingPartSet> buildingPartSets = new ArrayList<>();
                buildingPartSets.add(buildingPartSet);

                return buildingPartSets;
            }

            /**
             * to fill the field ArrayList<VillagerStatusQuantityPair> of the Api Class Building
             * create a list of villager required
             * Arg1 and Arg2 are alternate in a sorted String from the toString method of the form
             * create the list of VillagerStatusQuantityPair
             * @return Arraylist<VillagerStatusQuantityPAir>
             */
            private ArrayList<VillagerStatusQuantityPair> collectVillagerRequiredSubformData() {
                ArrayList<String> tmp = buildingForm.getSubPanelVillagerRequired().getJComponentToStringList();
                ArrayList<VillagerStatusQuantityPair> villagerStatus = new ArrayList<>();

                for(int i = 0; i< tmp.size(); i=i+2) {
                    //couple.clear();
                    VillagerStatusQuantityPair couple = new VillagerStatusQuantityPair(tmp.get(i), tmp.get(i + 1));
                    villagerStatus.add(couple);
                }
                return villagerStatus;

            }

        });
    }

}
