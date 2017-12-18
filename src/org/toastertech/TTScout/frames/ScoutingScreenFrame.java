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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

public class ScoutingScreenFrame extends JFrame implements ActionListener, WindowListener{
    /** This is just the index of the current match in our matches ArrayList **/
    int currentMatchIndex;

    //Widgets
    MatchDetailsPanel matchDetailsPanel;

    public ScoutingScreenFrame(Match match){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);

        //setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        setLayout(new GridLayout(2, 2));
        setVisible(true);

        addWindowListener(this);

        matchDetailsPanel = new MatchDetailsPanel(match);

        //This determines out starting index
        if(FileManager.currentMatches.contains(match)){
            currentMatchIndex = FileManager.currentMatches.indexOf(match); //If we ever pull off starting from a certain point
        } else {
            currentMatchIndex = 0; //Start at the beginning
        }

        add(matchDetailsPanel);
        add(new RatingPanel(0, 10, "Test Slider"));
        add(new JLabel());
        add(new BrowsingPanel(this));



        pack();


    }


    /**
     * This method will basically change our widgets so the values on them match that of the new match we are loading.
     */
    private void reconfigureWidgets(){
        Match newMatch = FileManager.currentMatches.get(currentMatchIndex);

        matchDetailsPanel.updatePanel(newMatch);

        System.out.println("NEW MATCH DETAILS");
        System.out.println(newMatch.toString());

        //REMOVE THESE METHODS AND ENACT THE WRATH OF CHITULU
        revalidate();
        repaint();
        revalidate();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Previous Match":
                moveToPreviousMatch();
                break;

            case "Next Match":
                moveToNextMatch();
                break;
        }
    }

    private void moveToPreviousMatch(){
        saveMatch();

        if(currentMatchIndex > 0){ //If this isn't the first match, then we can keep going backwards.
            currentMatchIndex -= 1;
        } else {
            JOptionPane.showConfirmDialog(new JDialog(), "This is your first match. So, you can't move back.");
        }

        reconfigureWidgets();
    }

    private void moveToNextMatch(){
        saveMatch(); //We are going to save the details of our current match

        // If this is the last match we have so far, we just need to create a new blank match
        if(currentMatchIndex == FileManager.currentMatches.size()-1){
            Match newMatch = new Match();
            FileManager.currentMatches.add(newMatch);

            JOptionPane.showConfirmDialog(new JDialog(), "Creating a New Match"); //Alert that will be removed later
        }

        currentMatchIndex += 1;

        reconfigureWidgets();

    }

    /**
     * This method saves the values from our widgets to the current match
     */
    private void saveMatch(){
        Match currentMatch = FileManager.currentMatches.get(currentMatchIndex);

        //Match Details Panel
        currentMatch.setMatchNum(Integer.valueOf(matchDetailsPanel.getValues()[0]));
        currentMatch.setTeamNum(Integer.valueOf(matchDetailsPanel.getValues()[1]));
        currentMatch.setScoutName(matchDetailsPanel.getValues()[2]);

        //Any other Widgets Start Here

        // Just a precaution cause Jonathan is paranoid
        FileManager.currentMatches.set(currentMatchIndex, currentMatch);

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("THE WINDOW IS DYING!!!");
        saveMatch();
        try {
            FileManager.writeFile();
        } catch (Exception exception){
            JOptionPane.showConfirmDialog(new JDialog(), exception.getMessage(), "Error", JOptionPane.OK_OPTION);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
