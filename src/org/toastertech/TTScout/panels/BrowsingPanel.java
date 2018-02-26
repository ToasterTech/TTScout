package org.toastertech.TTScout.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BrowsingPanel extends JPanel {
    JButton previousMatchButton = new JButton("Previous Match"),
            saveMatchesButton   = new JButton("Save Match"),
            nextMatchButton     = new JButton("Next Match");

    public BrowsingPanel(ActionListener callingFrame){
        super();
        previousMatchButton.addActionListener(callingFrame);
        saveMatchesButton.addActionListener(callingFrame);
        nextMatchButton.addActionListener(callingFrame);

        add(previousMatchButton);
        add(saveMatchesButton);
        add(nextMatchButton);


    }

}
