package org.toastertech.TTScout.frames;

import jdk.nashorn.internal.scripts.JO;
import org.toastertech.TTScout.data.FileManager;
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
        //Handling the Basic Background
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        //Adding Components
        setupTeamLogoAndHeading();
        add(programHeading);
        add(teamLogoLabel);


        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){

        }

        setupButtonPanel();
        add(buttonPanel);

        getContentPane().setBackground(Color.BLACK);

        pack();
        repaint();
        revalidate();
        setVisible(true); //Display
    }

    private void setupTeamLogoAndHeading(){
        ImageIcon teamLogo = new ImageIcon(this.getClass().getClassLoader().getResource("ttlogo.png"));
        teamLogoLabel.setIcon(teamLogo);

        programHeading.setFont(new Font(programHeading.getFont().getName(), programHeading.getFont().getStyle(), 40));
        programHeading.setForeground(Color.WHITE);

        teamLogoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        programHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void setupButtonPanel(){

        oldFilesButton.setFocusable(false);
        //newFileButton.setFocusable(false);

        oldFilesButton.addActionListener(this);
        //newFileButton.addActionListener(this);

        buttonPanel.add(oldFilesButton);
        //buttonPanel.add(newFileButton);

        add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Select Saved Match":
                String[] competitions = {"Gainesville", "Dalton", "Albany", "Columbus", "Duluth", "State", "World's"};
                String result = (String)JOptionPane.showInputDialog(new JDialog(), "Select a Competition: ", "Hi", JOptionPane.PLAIN_MESSAGE,
                        null, competitions, null);

                FileManager.currentCompetition = result;

                try {
                    FileManager.readFile();
                    new ScoutingScreenFrame(FileManager.currentMatches.get(0));
                } catch (Exception error){
                    JOptionPane.showConfirmDialog(new JDialog(), error.getMessage(), null, JOptionPane.OK_CANCEL_OPTION);
                }

                break;
        }
    }



}
