package org.toastertech.TTScout.panels;

import javax.swing.*;
import java.awt.*;

public class RatingPanel extends JPanel {
    private int minRating, maxRating;

    private JSlider slider;
    public RatingPanel(int minRating, int maxRating, String question) {
        //Assign Variables
        this.minRating    = minRating;
        this.maxRating    = maxRating;

        //Configure Representation
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        slider = new JSlider(this.minRating, this.maxRating);

        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBorder(BorderFactory.createTitledBorder(question));

        add(slider);
    }

    public int getCurrentRating(){
        return slider.getValue();
    }
}
