package org.toastertech.TTScout.panels;

import org.toastertech.TTScout.data.Match;

import javax.swing.*;

public class MatchDetailsPanel extends JPanel {
    JLabel matchNumLabel,
            teamNumLabel,
            scoutNameLabel;

    JTextField matchNumField,
            teamNumField,
            scoutNameField;

    JButton competitionButton;

    public MatchDetailsPanel(Match match){
        matchNumLabel  = new JLabel("Match Number: ");
        teamNumLabel   = new JLabel("Team Number: ");
        scoutNameLabel = new JLabel("Scout Name: ");

        matchNumField  = new JTextField();
        teamNumField   = new JTextField();
        scoutNameField = new JTextField();

        matchNumField  .setText(String.valueOf(match.getMatchNum()));
        teamNumField   .setText(String.valueOf(match.getTeamNum()));
        scoutNameField .setText(match.getScoutName());

        matchNumField.setColumns(5);
        teamNumField.setColumns(5);
        scoutNameField.setColumns(5);

        add(matchNumLabel);
        add(matchNumField);
        add(scoutNameLabel);
        add(scoutNameField);
        add(teamNumLabel);
        add(teamNumField);
    }
}
