package fr.foundation.modwizard.view.custom;

import fr.foundation.modwizard.view.custom.CustomPanelForDynamicPanelOfJComponent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SubPanelBuildingPart extends CustomPanelForDynamicPanelOfJComponent {


    @Override
    protected void createCustomJComponentLine(JPanel fieldPanel, GridBagLayout layout, int NB_JCOMPONENTS_PER_FIELD, int row) {
        for(int i=0; i<NB_JCOMPONENTS_PER_FIELD; i++) {
            GridBagConstraints constraint=new GridBagConstraints();
            constraint.gridx=i;
            constraint.gridy=row;
            JTextField myNewTextField = new JTextField("",10);
            fieldPanel.add(myNewTextField,constraint,i);
        }
        fieldPanel.revalidate();

    }


    @Override
    public  void getValuesOfJComponents(JPanel fieldPanel, ArrayList<String> jComponentToStringList) {
        Component[] components = fieldPanel.getComponents();
        jComponentToStringList.clear();
        for(int i=components.length-1;i>=0;i--){
            if(components[i] instanceof JTextField){
                JTextField tmp = (JTextField)components[i];
                String txt = tmp.getText();
                if(!txt.equals(""))
                    jComponentToStringList.add(txt);
            }
        }
        System.out.println(jComponentToStringList.toString());

    }

    @Override
    protected void setButtonMinusAction(JPanel fieldPanel) {
        Component[] c = fieldPanel.getComponents();
        for (int i = c.length - 1; i > c.length - 2; i--) {
            if (i > 0) {
                fieldPanel.remove(c[i]);
            }
        }
        repack();
    }

    @Override
    protected void setButtonPlusAction(JPanel fieldPanel, GridBagLayout layout, int row, ArrayList<String> jComponentToStringList) {
        row++;
        createCustomJComponentLine(fieldPanel, layout, 1, row);
        //getValuesOfJComponents(fieldPanel, jComponentToStringList);

        repack();
    }


}
