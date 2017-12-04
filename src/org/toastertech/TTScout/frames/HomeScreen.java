package org.toastertech.TTScout.frames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class HomeScreen extends JFrame implements ActionListener {
    JLabel title = new JLabel();

    JPanel buttonPanel = new JPanel(new FlowLayout());

    JButton oldFilesButton = new JButton("Select Saved Match");
    JButton newFileButton = new JButton("Create New Match");

    public HomeScreen(){
        System.out.println(new File(".").getAbsolutePath());
        //Handling the Basic Background
        setVisible(true); //Display
        setResizable(false);
        setSize(600,400); //Screen Size - Should be Resizable
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));


        //Adding Components
        //title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 40));
        setupTeamLogo();
        add(title);

        setupButtonPanel();
        add(buttonPanel);

        //DO NOT REMOVE. I don't know why, this is the only way stuff will show up
        //Remove and the Citadel of Ricks will come for you
        repaint();
        revalidate();
    }

    private void setupTeamLogo(){
        File teamLogoFile = new File("res/ttlogo.png"); //This establishes a link to the logo file
        System.out.println(teamLogoFile.exists()); //Tells us if it actually sees the picture file
        ImageIcon teamLogo = new ImageIcon(teamLogoFile.getPath()); //This creates the Image for Swing
        title.setIcon(teamLogo); //We display the logo!

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
                new CreateMatchFrame();
                break;
        }
    }

}
