package org.toastertech.TTScout.panels;


import org.toastertech.TTScout.data.Match;
import javax.swing.*;
import org.supercsv.cellprocessor.*;
import org.toastertech.TTScout.frames.HomeScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This JPanel will be used by the user to create a match.
 */
public class CreateMatchPanel extends JPanel implements ActionListener{
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

    JButton submitButton = new JButton("Submit"),
            selectEventButton = new JButton("Select Event");

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
        //eventNameField.setColumns(5);
        //eventNamePanel.add(eventNameField);
        selectEventButton.addActionListener(this);
        eventNamePanel.add(selectEventButton);


        add(matchNumPanel);
        add(teamNumPanel);
        add(scoutNamePanel);
        add(eventNamePanel);
    }

    /**
     * This lets us know if the text entered in the boxes is data we can work with. If we can't work with this
     * data, the method returns false.
     *
     * @return
     */
    public boolean textIsValid(){
        try{ //This will throw an error if we can't get a valid input
            Integer.valueOf(matchNumField.getText().toString()); //Are there characters that are not numbers?
            Integer.valueOf(teamNumField.getText().toString()); // Same Question

            //Is there nothing in either of these fields?
            if(scoutNameField.getText().length() <= 0){
                throw new Exception(); //This will throw an exception, letting us know that we need to change the input.
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Return an empty match object for the user to work with. All it contains is the data inputted in this panel.
     * @return
     */
    public Match getMatch(){
        return new Match(Integer.valueOf(matchNumField.getText().toString()), Integer.valueOf(teamNumField.getText().toString()),
                        scoutNameField.getText(), selectEventButton.getText());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == selectEventButton.getActionCommand()){
            String[] competitions = {"Gainesville", "Dalton", "Albany", "Columbus", "Duluth", "State", "World's"};
            selectEventButton.setText((String) JOptionPane.showInputDialog(null, "", "Select an Event: ",
                    JOptionPane.QUESTION_MESSAGE, null,
                    competitions, competitions[2]));
        }
    }
}
