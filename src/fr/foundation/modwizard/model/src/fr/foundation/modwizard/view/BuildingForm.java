package fr.foundation.modwizard.view;


import fr.foundation.modwizard.model.VillagerStatusQuantityPair;
import fr.foundation.modwizard.model.enumeration.BuildingType;
import fr.foundation.modwizard.model.enumeration.Desirability;
import fr.foundation.modwizard.view.custom.*;
import fr.foundation.modwizard.view.custom.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Objects;


public class BuildingForm extends View{

    SubPanelBuildingPart subpanelBuildingpart;
    SubPanelVillagerRequired subPanelVillagerRequired;


    public JPanel buildingform;
    public JLabel nameLabel;
    public JTextField name;
    public JLabel descLabel;
    public JTextField description;
    public JLabel orderIdLabel;
    public JTextField orderId;
    public JLabel buildingPartSetListLabel;
    public JComboBox buildingTypeComboBox;
    public JLabel BuildingModelLabel;
    public JTextField buildingModel;
    public JLabel desirabilityLabel;
    public JComboBox desirabilityComboBox;
    public JCheckBox isManuallyUnlockedBox;
    public JCheckBox isDestructibleBox;
    public JCheckBox isEditableBox;
    public JCheckBox isHiddenBox;
    public JCheckBox isClearTreesBox;
    public JLabel buildingTypeLabel;
    public JLabel villagerRequiredLabel;
    public JButton nextButton;
    private JPanel villagerRequiredPanel;
    private JPanel buildingpartListPanel;
    public JTextPane codePane;
    static JTextField subFormTextField;
    private JPanel fieldPanel;
    public JLabel buildingType;
    public JComboBox comboBox1;


    public BuildingForm() {

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    generateBuildingCode();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

    private void generateBuildingCode() throws IllegalAccessException {
        //get the main Form Data
            String dataType = "Building";
            String id = "BuildingId";
            String name = getName().getText();
            String description = getDescription().getText();
            String orderId = getOrderId().getText();
            String buildingType = Objects.requireNonNull(getBuildingTypeComboBox().getSelectedItem()).toString();
            String buildingModel = getBuildingModel().getText();
            ArrayList<VillagerStatusQuantityPair> villagerRequired;
            String desirabilityLayer = Objects.requireNonNull(getDesirabilityComboBox().getSelectedItem()).toString();
            boolean isManuallyUnlocked = getIsManuallyUnlockedBox().isSelected();
            boolean isDestructible = getIsDestructibleBox().isSelected();
            boolean isEditable = getIsEditableBox().isSelected();
            boolean isHidden = getIsHiddenBox().isSelected();
            boolean isClearTrees = getIsClearTreesBox().isSelected();


    }




    private void createUIComponents() {
        // TODO: place custom component creation code here

        MyEnumComboBox buildingTypeCbx = new MyEnumComboBox(BuildingType.toStringList());
        buildingTypeComboBox = buildingTypeCbx.getCbx();

        MyEnumComboBox desirabilityCbx = new MyEnumComboBox(Desirability.toStringList());
        desirabilityComboBox = desirabilityCbx.getCbx();

        //Jpanel BuildingPartsListPanel with one + button that add new JtextField on clic
        subpanelBuildingpart = new SubPanelBuildingPart();
        buildingpartListPanel= subpanelBuildingpart.getCustomPanel();


        //Jpanel VillagerRequired with 2 raw of JcomboBox add a new line on clic
        subPanelVillagerRequired = new SubPanelVillagerRequired();
        villagerRequiredPanel = subPanelVillagerRequired.getCustomPanel();

        //JtextArea  codePanel display the building lua script


        codePane = new JTextPane();











    }

    public JTextPane getCodePane() {
        return codePane;
    }

    public void setBuildingModel(JTextField buildingModel) {
        this.buildingModel = buildingModel;
    }

    public SubPanelBuildingPart getSubpanelBuildingpart() {
        return subpanelBuildingpart;
    }

    public SubPanelVillagerRequired getSubPanelVillagerRequired() {
        return subPanelVillagerRequired;
    }

    public JPanel getBuildingform() {
        return buildingform;
    }

    public JTextField getName() {
        return name;
    }

    public JTextField getDescription() {
        return description;
    }

    public JTextField getOrderId() {
        return orderId;
    }

    public JComboBox getBuildingTypeComboBox() {
        return buildingTypeComboBox;
    }

    public JTextField getBuildingModel() {
        return buildingModel;
    }

    public JComboBox getDesirabilityComboBox() {
        return desirabilityComboBox;
    }

    public JCheckBox getIsManuallyUnlockedBox() {
        return isManuallyUnlockedBox;
    }

    public JCheckBox getIsDestructibleBox() {
        return isDestructibleBox;
    }

    public JCheckBox getIsEditableBox() {
        return isEditableBox;
    }

    public JCheckBox getIsHiddenBox() {
        return isHiddenBox;
    }

    public JCheckBox getIsClearTreesBox() {
        return isClearTreesBox;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    @Override
    public void display() {
        Frame frame = new Frame(buildingform);
    }
}
