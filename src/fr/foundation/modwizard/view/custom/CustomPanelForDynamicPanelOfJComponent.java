package fr.foundation.modwizard.view.custom;

import javax.swing.*;
import java.awt.Frame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class CustomPanelForDynamicPanelOfJComponent {

    private JPanel customPanel;
    private ArrayList<String> jComponentToStringList = new ArrayList<>();

    /**
     * Create an empty panel with a + and a minus button
     */
    public CustomPanelForDynamicPanelOfJComponent() {
        //create a panel
        final JPanel panel = new JPanel();

        //set a layout
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        //add a + and Minus button

        JButton buttonPlus = new JButton("+");
        addButton(panel,buttonPlus);
        JButton buttonMinus = new JButton("-");
        addButton(panel,buttonMinus);




        //add a panel in the panel to add a scrollbar if needed
        final JPanel fieldpanel = new JPanel();
        panel.add(new JScrollPane(fieldpanel));


        //define a layout that can be use to add lines
        final GridBagLayout layout = new GridBagLayout();
        fieldpanel.setLayout(layout);

        customPanel = panel;


        buttonPlus.addActionListener(new ActionListener() {

            int row = 0;

            public void actionPerformed(ActionEvent e) {
                setButtonPlusAction(fieldpanel,layout,row++,jComponentToStringList);
                getValuesOfJComponents(fieldpanel,jComponentToStringList);

            }

        });

        buttonMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setButtonMinusAction(fieldpanel);

            }
        });
    }

    protected abstract void getValuesOfJComponents(JPanel fieldPanel, ArrayList<String> jComponentToStringList);

    protected abstract void setButtonMinusAction(JPanel fieldPanel);

    protected abstract void setButtonPlusAction( JPanel fieldPanel, GridBagLayout layout, int row, ArrayList<String> jComponentToStringList);

    /**
     * Define this method to create your line of JComponents
     * @param fieldPanel
     * @param layout
     * @param row initial nb of raw
     */
    protected abstract void createCustomJComponentLine(JPanel fieldPanel, GridBagLayout layout, int nbComponentPerField, int row);

    /**
     * Add button to a panel
     * Set a left Alignement
     * @param panel panel to fill with
     * @param buttonToAdd button to add
     */
    public void addButton(JPanel panel, JButton buttonToAdd) {

        buttonToAdd.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(buttonToAdd);

    }

    /**
     * pack all Frames
     */
    public void repack() {
        Frame[] frames = JFrame.getFrames();
        for (int i = 0; i < frames.length; i++) {
            frames[i].pack();
        }
    }

    /**
     * Property
     * @return panel
     */
    public JPanel getCustomPanel() {
        return customPanel;
    }

    public ArrayList<String> getJComponentToStringList() {
        return jComponentToStringList;
    }
}
