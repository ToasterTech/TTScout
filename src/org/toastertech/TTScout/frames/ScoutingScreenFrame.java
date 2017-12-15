package org.toastertech.TTScout.frames;

import org.toastertech.TTScout.data.FileManager;
import org.toastertech.TTScout.data.Match;
import org.toastertech.TTScout.panels.MatchDetailsPanel;
import org.toastertech.TTScout.panels.RatingPanel;

import javax.swing.*;
import java.awt.*;

public class ScoutingScreenFrame extends JFrame{
    Match currentMatch;

    public ScoutingScreenFrame(Match match){
        setSize(800, 800);

        //setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        setLayout(new GridLayout(2, 2));
        setVisible(true);

        currentMatch = match;

        FileManager.currentCompetition = match.getCompetitionName();

        add(new MatchDetailsPanel(match));
        add(new RatingPanel(0, 10, "Test Slider"));

        pack();

        try{
            FileManager.writeFile();
        } catch (Exception e){

        }

    }

}
