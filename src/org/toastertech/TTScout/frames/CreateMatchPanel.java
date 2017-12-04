package org.toastertech.TTScout.frames;


import org.toastertech.TTScout.data.Match;

import javax.swing.*;

public class CreateMatchPanel extends JPanel{
    JLabel     matchNumLabel = new JLabel("Match Number: "),
              teamNumLabel   = new JLabel("Team Number: "),
              scoutNameLabel = new JLabel("   Scout Name: "),
              eventNameLabel = new JLabel("    Event Name: "),
                programHeadingLabel;

    JTextField matchNumField = new JTextField(),
            teamNumField = new JTextField(),
            scoutNameField = new JTextField(),
            eventNameField = new JTextField();

    JPanel      matchNumPanel = new JPanel(),
                teamNumPanel = new JPanel(),
                scoutNamePanel = new JPanel(),
                eventNamePanel = new JPanel();

    JButton submitButton = new JButton("Submit");



    public CreateMatchPanel(HomeScreen homeScreen){
        // Setup
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //Add Layout
        setupPanels();

        revalidate();
        repaint();

        submitButton.setActionCommand("Submit New Match Details");
        submitButton.addActionListener(homeScreen);

        add(submitButton);
    }

    private void setupPanels(){
        matchNumPanel.add(matchNumLabel);
        matchNumField.setColumns(5);
        matchNumPanel.add(matchNumField);

        teamNumPanel.add(teamNumLabel);
        teamNumField.setColumns(5);
        teamNumPanel.add(teamNumField);

        scoutNamePanel.add(scoutNameLabel);
        scoutNameField.setColumns(5);
        scoutNamePanel.add(scoutNameField);

        eventNamePanel.add(eventNameLabel);
        eventNameField.setColumns(5);
        eventNamePanel.add(eventNameField);

        add(matchNumPanel);
        add(teamNumPanel);
        add(scoutNamePanel);
        add(eventNamePanel);
    }

    public boolean textIsValid(){
        try{ //This will throw an error if we can't get a valid input
            int matchNum = Integer.valueOf(matchNumField.getText().toString());
            int teamNum = Integer.valueOf(teamNumField.getText().toString());

            if(scoutNameField.getText().length() <= 0 || eventNameField.getText().length() <= 0){
                throw new Exception();
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Match getMatch(){
        return new Match(Integer.valueOf(matchNumField.getText().toString()), Integer.valueOf(teamNumField.getText().toString()),
                        scoutNameField.getText(), eventNameField.getText());

    }

}
