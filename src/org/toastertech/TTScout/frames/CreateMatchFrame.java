package org.toastertech.TTScout.frames;

import javax.swing.*;
import java.awt.*;

public class CreateMatchFrame extends JFrame{
    JLabel     matchNumLabel = new JLabel("Match Number: "), teamNumLabel, scoutNameLabel, eventNameLabel;
    JTextField matchNumField = new JTextField(), teamNumField, scoutNameField, eventNameField;
    JPanel     matchNumPanel, teamNumPanel, scoutNamePanel, eventNamePanels;


    public CreateMatchFrame(){
        // Setup
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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
