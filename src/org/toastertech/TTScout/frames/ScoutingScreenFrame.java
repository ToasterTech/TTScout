package org.toastertech.TTScout.frames;

import org.toastertech.TTScout.data.FileManager;
import org.toastertech.TTScout.data.Match;
import org.toastertech.TTScout.panels.BrowsingPanel;
import org.toastertech.TTScout.panels.MatchDetailsPanel;
import org.toastertech.TTScout.panels.RatingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoutingScreenFrame extends JFrame implements ActionListener{
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
        add(new JLabel());
        add(new BrowsingPanel(this));

        pack();

        try{
            FileManager.writeFile();
        } catch (Exception e){

        }

    }

    private void initializeFrame(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Previous":

                break;

            case "Next":

                break;
        }
    }

    private void moveToPreviousMatch(){
        if(FileManager.currentMatches.indexOf(currentMatch) > 0){
            //Move to Previous Match
        }
    }

    private void moveToNextMatch(){
        if(FileManager.currentMatches.indexOf(currentMatch) < FileManager.currentMatches.size()-1){
            //Move to Next Match
        }
    }
}
