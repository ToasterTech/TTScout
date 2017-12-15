package org.toastertech.TTScout.panels;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BrowsingPanel extends JPanel {
    JButton previousMatchButton = new JButton("Previous Match"),
            nextMatchButton     = new JButton("Next Match");

    public BrowsingPanel(ActionListener callingFrame){
        previousMatchButton.addActionListener(callingFrame);
        nextMatchButton.addActionListener(callingFrame);

        add(previousMatchButton);
        add(nextMatchButton);
    }

}
