package org.toastertech.TTScout.frames;

import javax.swing.*;
import java.awt.*;

public class CreateMatchPanel extends JPanel{
    JLabel     matchNumLabel = new JLabel("Match Number: "),
            teamNumLabel = new JLabel("Team Number: "),
            scoutNameLabel = new JLabel("Scout Name: "),
            eventNameLabel = new JLabel("Event Name: ");

    JTextField matchNumField = new JTextField(),
            teamNumField = new JTextField(),
            scoutNameField = new JTextField(),
            eventNameField = new JTextField();

    JPanel      matchNumPanel = new JPanel(),
                teamNumPanel = new JPanel(),
                scoutNamePanel = new JPanel(),
                eventNamePanels = new JPanel();


    public CreateMatchPanel(){
        // Setup
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(800, 800);
        setVisible(true);
        //Add Layout
        setupPanels();
    }

    private void setupPanels(){
        matchNumPanel.add(matchNumLabel);
        matchNumField.setColumns(5);
        matchNumPanel.add(matchNumField);

        teamNumPanel.add(teamNumLabel);
        teamNumField.setColumns(5);
        teamNumPanel.add(teamNumField);

        add(matchNumPanel);
        add(teamNumPanel);
    }

}
