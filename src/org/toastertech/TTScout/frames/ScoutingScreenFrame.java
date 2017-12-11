package org.toastertech.TTScout.frames;

import org.toastertech.TTScout.data.Match;
import org.toastertech.TTScout.panels.MatchDetailsPanel;
import org.toastertech.TTScout.panels.RatingPanel;

import javax.swing.*;

public class ScoutingScreenFrame extends JFrame{
    Match currentMatch;

    public ScoutingScreenFrame(Match match){
            setSize(800, 800);
            setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
            setVisible(true);

            currentMatch = match;
            add(new MatchDetailsPanel(match));
            add(new RatingPanel(0, 10, "Test Slider"));

    }

}
