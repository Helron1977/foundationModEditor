package fr.foundation.modwizard.view.custom;


import fr.foundation.modwizard.model.enumeration.VillagerStatus;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class SubPanelVillagerRequired extends CustomPanelForDynamicPanelOfJComponent {


    /**
     *This custom + button add a row in a GridLayout of 1 Component and repack the frames
     * @param fieldPanel panel that contains the rows
     * @param layout name of the layout in the CustomPanelClass
     * @param row initial number of raw in the fieldPAnel
     * @param jComponentToStringList dedicated variable to store the content the Jcomponents
     */
    @Override
    protected void setButtonPlusAction(JPanel fieldPanel, GridBagLayout layout, int row, ArrayList<String> jComponentToStringList) {
        row++;
        createCustomJComponentLine(fieldPanel, layout,1, row);
        repack();
    }

    /**
     * This custom - button remove a raw in the fieldPanel if there is at least 2 raws and repack the frames
     * @param fieldPanel container of the raws
     */
    @Override
    protected void setButtonMinusAction(JPanel fieldPanel) {
        Component[] components = fieldPanel.getComponents();
        for (int i = components.length - 1; i > components.length - 2; i--) {
            if (i > 2) {
                fieldPanel.remove(components[i]);
                fieldPanel.remove(components[i - 1]);
            }
        }
        repack();
    }


    /**
     * This custom panel a custom ComboBox and a spinner
     * @param fieldPanel Container of the row
     * @param layout Layoutmanager GridBagLayout
     * @param nbComponentPerField Do not modify
     * @param row initial nb of raw
     */
    @Override
    protected void createCustomJComponentLine(JPanel fieldPanel, GridBagLayout layout, int nbComponentPerField, int row) {
        for(int i=0; i<nbComponentPerField; i++)
        {
            GridBagConstraints constraintComboBox=new GridBagConstraints();
            constraintComboBox.gridx=i;
            constraintComboBox.gridy=row;
            GridBagConstraints constraintField= new GridBagConstraints();
            constraintField.gridx=i+1;
            constraintField.gridy=row;
            MyEnumComboBox cbx = new MyEnumComboBox(VillagerStatus.toStringList());
            fieldPanel.add(cbx.getCbx(),constraintComboBox,i);
            JSpinner txt = new JSpinner();
            fieldPanel.add(txt,constraintField,i);

        }
        fieldPanel.revalidate();
    }


    @Override
    protected void getValuesOfJComponents(JPanel fieldPanel, ArrayList<String> jComponentToStringList) {
        Component[] components = fieldPanel.getComponents();
        jComponentToStringList.clear();

        //loop start from the end to check the last one
        for(int i=components.length-1; i>0; i--){

            if(components[i] instanceof JSpinner){
                //the component of the panel are added by the first index
                //so the next one in this loop from the end is +1
                JComboBox cbx = (JComboBox)components[i+1];
                JSpinner spn = (JSpinner)components[i];

                String cbxtxt = Objects.requireNonNull(cbx.getSelectedItem()).toString();
                String spntxt = spn.getValue().toString();

                if(!spntxt.contains("0")){
                    jComponentToStringList.add(cbxtxt);
                    //System.out.println(cbxtxt);
                    jComponentToStringList.add(spntxt);
                    //System.out.println(spntxt);

                }

            }

        }
        //System.out.println(jComponentToStringList.toString());

    }

}
