package org.toastertech.TTScout.frames;

import org.toastertech.TTScout.panels.CreateMatchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class HomeScreen extends JFrame implements ActionListener {
    JLabel teamLogoLabel = new JLabel();
    JLabel programHeading = new JLabel("   Toaster Scout   ");
    //Comment to test Discord Bot

    JPanel buttonPanel = new JPanel(new FlowLayout());

    JButton oldFilesButton = new JButton("Select Saved Match");
    JButton newFileButton = new JButton("Create New Match");

    CreateMatchPanel matchCreatePanel;

    public HomeScreen(){
        super("Toaster Scout");
        System.out.println(new File(".").getAbsolutePath());
        //Handling the Basic Background
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        //Adding Components
        setupTeamLogoAndHeading();
        add(programHeading);
        add(teamLogoLabel);


        setupButtonPanel();
        add(buttonPanel);

        pack();
        repaint();
        revalidate();
        setVisible(true); //Display
    }

    private void setupTeamLogoAndHeading(){
        ImageIcon teamLogo = new ImageIcon(this.getClass().getClassLoader().getResource("ttlogo.png"));
        teamLogoLabel.setIcon(teamLogo);

        programHeading.setFont(new Font(programHeading.getFont().getName(), programHeading.getFont().getStyle(), 40));

        teamLogoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        programHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void setupButtonPanel(){


        oldFilesButton.addActionListener(this);
        newFileButton.addActionListener(this);

        buttonPanel.add(oldFilesButton);
        buttonPanel.add(newFileButton);

        add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Select Saved Match":

                break;

            case "Create New Match":
                remove(buttonPanel);

                matchCreatePanel = new CreateMatchPanel(this);
                add(matchCreatePanel);
                revalidate();
                repaint();
                pack();
                break;

            case "Submit New Match Details":
                if(matchCreatePanel.textIsValid()){
                    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    dispose(); //Kill Home Screen - Remove and Suffer from Pain
                    new ScoutingScreenFrame(matchCreatePanel.getMatch()); //Create Home Screen


                } else {
                    programHeading.setText("INVALID INPUT");
                }
        }
    }

}
