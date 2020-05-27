package fr.foundation.modwizard.view.custom;


import javax.swing.*;

public class MyEnumComboBox extends JComboBox {

    JComboBox cbx = new JComboBox();



    public MyEnumComboBox(String[] enumToStringToUse) {
        addEnumValuesTo(enumToStringToUse,cbx);
    }


    private void addEnumValuesTo(String[] enumListToAddTo, JComboBox comboBoxToFill ){
        for(int i=0; i<enumListToAddTo.length;i++){
            comboBoxToFill.addItem(enumListToAddTo[i]);
        }
    }

    public JComboBox getCbx() {
        return cbx;
    }
}

