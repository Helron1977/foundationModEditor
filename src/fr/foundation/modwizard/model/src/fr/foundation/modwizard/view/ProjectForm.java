package fr.foundation.modwizard.view;


import fr.foundation.modwizard.view.custom.Frame;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ProjectForm extends View{
    private JPanel projectForm;
    private JTextField FbxNameField;
    private JTextPane welcome;
    private JTextField ProjectField;
    private JButton next;
    private JLabel projectNameLabel;
    private JLabel FbxLabel;
    private JEditorPane summary;


    /**
     * View constructor ProjectForm
     */
    public ProjectForm()  {
        initWelcomePanel();
        initSummaryPanel();
    }

    private void initSummaryPanel() {
        String htmlCode = "<ul><a href=\"/foundation/modding/start\"<img src=\"https://www.polymorph.games/foundation/modding/lib/tpl/dokuwiki/images/logo.png\"</ul> <li>Foundation - Modding Documentation</li>";
        String url = "https://www.polymorph.games/foundation/modding/start#welcome_to_the_foundation_modding_wiki";
        summary.setContentType("text/html");
        summary.setEditable(false);
        summary.setOpaque(false);
        summary.setText(htmlCode);
        summary.addHyperlinkListener(new HyperlinkListener(){

            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (HyperlinkEvent.EventType.ACTIVATED.equals(e.getEventType()))
                {
                    try {
                        Desktop.getDesktop().browse((new URL(url).toURI()));
                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    private void initWelcomePanel() {
        String welcomeTxt ="Welcome to your Foundation Mod Wizzard.\nLet's start and chose a name for your mod and give the name of your fbx file.\n \n Then click next !";
        welcome.setText(welcomeTxt);
    }


    public JPanel getProjectForm() {
        return projectForm;
    }


    public JTextField getFbxNameField() {
        return FbxNameField;
    }


    public JTextField getProjectField() {
        return ProjectField;
    }


    public void setNext(JButton next) {
        this.next = next;
    }

    public JLabel getProjectNameLabel() {
        return projectNameLabel;
    }

    public JLabel getFbxLabel() {
        return FbxLabel;
    }

    public JButton getNext() {
        return next;
    }


    @Override
    public void display() {
        Frame frame = new Frame(projectForm);
    }
}
