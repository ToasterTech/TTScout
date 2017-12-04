package org.toastertech.TTScout.frames;

import javax.swing.*;
import java.awt.*;

public class CreateMatchPanel extends JPanel{
    JLabel     matchNumLabel = new JLabel("Match Number: "), teamNumLabel, scoutNameLabel, eventNameLabel;
    JTextField matchNumField = new JTextField(), teamNumField, scoutNameField, eventNameField;
    JPanel     matchNumPanel, teamNumPanel, scoutNamePanel, eventNamePanels;


    public CreateMatchPanel(){
        // Setup
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(800, 800);
        setVisible(true);
        //Add Layout
        setupPanels();
    }

    private void setupPanels(){
        matchNumPanel = new JPanel(new FlowLayout());
        matchNumPanel.add(matchNumLabel);
        matchNumField.setColumns(5);
        matchNumPanel.add(matchNumField);


        add(matchNumPanel);
    }

}
