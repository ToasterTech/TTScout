package org.toastertech.TTScout.frames;

import org.toastertech.TTScout.data.FileManager;
import org.toastertech.TTScout.data.Match;
import org.toastertech.TTScout.panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ScoutingScreenFrame extends JFrame implements ActionListener, WindowListener{
    /** This is just the index of the current match in our matches ArrayList **/
    int currentMatchIndex;
    GridBagConstraints constraints = new GridBagConstraints();
    //Widgets
    MatchDetailsPanel matchDetailsPanel;

    MultipleCheckboxPanel autoScoringPanel;
    NumberInputPanel      teleopOwnAllianceSwitchBricks;
    NumberInputPanel      teleopOppositeAllianceSwitchBricks;
    NumberInputPanel teleopScaleBricks;
    NumberInputPanel      teleopVaultBricks;
    MultipleCheckboxPanel powerCubePanel;
    MultipleCheckboxPanel climbPanel;
    RatingPanel           defensePanel;
    MultipleCheckboxPanel foulsObtained;

    BrowsingPanel browsingPanel;

    JPanel mainPanel = new JPanel();

    public ScoutingScreenFrame(Match match){


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setSize(800, 800);

        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        //setLayout(new GridLayout(3, 3));
        setVisible(true);

        addWindowListener(this);


        matchDetailsPanel = new MatchDetailsPanel(match);


        autoScoringPanel = new MultipleCheckboxPanel("Auto Score", "Scale", "Switch", "Auto Line");
        teleopOwnAllianceSwitchBricks = new NumberInputPanel("Number of Blocks on Own Switch", "Block", 0);
        teleopOppositeAllianceSwitchBricks = new NumberInputPanel("Number of Blocks on Opposite Switch", "Block", 0);
        teleopScaleBricks = new NumberInputPanel("Number of Blocks on Scale", "Block", 0);
        teleopVaultBricks = new NumberInputPanel("Number of Blocks in Vault", "Block", 0);
        climbPanel = new MultipleCheckboxPanel("Climb Status:", "Attempted Climb", "Climbed", "Parked");
        powerCubePanel = new MultipleCheckboxPanel( "Location of Power Cube Pickups", "Pile", "Switch", "Exchange", "Portal");
        defensePanel = new RatingPanel(0, 10, "Defensive Rating");
        foulsObtained = new MultipleCheckboxPanel("Fouls Obtained", "Foul", "Tech Foul", "Yellow Card");


        browsingPanel = new BrowsingPanel(this);


        //This determines out starting index
        if(FileManager.currentMatches.contains(match)){
            currentMatchIndex = FileManager.currentMatches.indexOf(match); //If we ever pull off starting from a certain point
        } else {
            currentMatchIndex = 0; //Start at the beginning
        }

        add(matchDetailsPanel);

        //mainPanel.setLayout(new GridLayout(3, 3, 4, 4));
        mainPanel.setLayout(new GridBagLayout());


        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx=1.0;
        constraints.weighty=1.0;
        constraints.fill = GridBagConstraints.BOTH;

        mainPanel.add(autoScoringPanel, constraints);
        incrementConstrainst();
        mainPanel.add(teleopOwnAllianceSwitchBricks, constraints);
        incrementConstrainst();
        mainPanel.add(teleopOppositeAllianceSwitchBricks, constraints);
        incrementConstrainst();

        mainPanel.add(teleopScaleBricks, constraints);
        incrementConstrainst();

        mainPanel.add(teleopVaultBricks, constraints);
        incrementConstrainst();

        mainPanel.add(climbPanel, constraints);
        incrementConstrainst();

        mainPanel.add(powerCubePanel, constraints);
        incrementConstrainst();

        mainPanel.add(defensePanel, constraints);
        incrementConstrainst();

        mainPanel.add(foulsObtained, constraints);
        incrementConstrainst();

        reconfigureWidgets();



        add(mainPanel);
        add(browsingPanel);


        pack();


    }

    private void incrementConstrainst(){
        if(constraints.gridy == 2){
            constraints.gridx+=1;
            constraints.gridy=0;
        } else {
            constraints.gridy+=1;
        }
    }

    /**
     * This method will basically change our widgets so the values on them match that of the new match we are loading.
     */
    private void reconfigureWidgets(){
        Match newMatch = FileManager.currentMatches.get(currentMatchIndex);

        matchDetailsPanel.updatePanel(newMatch);

        teleopOwnAllianceSwitchBricks.setValue(newMatch.getBlocksOnOwnSwitch());
        teleopOppositeAllianceSwitchBricks.setValue(newMatch.getBlocksOnOppositeSwitch());
        teleopScaleBricks.setValue(newMatch.getBlocksOnScale());
        teleopVaultBricks.setValue(newMatch.getBlocksInVault());

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

        //currentMatch.setAutoScaleStatus(autoScoringPanel.getResults()[0]);
        //currentMatch.setAutoSwitchStatus(autoScoringPanel.getResults()[1]);
        //currentMatch.setAutoSwitchStatus(autoScoringPanel.getResults()[2]);

        //Any other Widgets Start Here
        currentMatch.setBlocksOnOwnSwitch(teleopOwnAllianceSwitchBricks.getValue());
        currentMatch.setBlocksOnOppositeSwitch(teleopOppositeAllianceSwitchBricks.getValue());
        currentMatch.setBlocksOnScale(teleopScaleBricks.getValue());
        currentMatch.setBlocksInVault(teleopVaultBricks.getValue());

        // Just a precaution cause Jonathan is paranoid
        FileManager.currentMatches.set(currentMatchIndex, currentMatch);

    }

    @Override
    public void windowOpened(WindowEvent e) { }

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
    public void windowClosed(WindowEvent e) { }

    @Override
    public void windowIconified(WindowEvent e) { }

    @Override
    public void windowDeiconified(WindowEvent e) { }

    @Override
    public void windowActivated(WindowEvent e) { }

    @Override
    public void windowDeactivated(WindowEvent e) { }

}
