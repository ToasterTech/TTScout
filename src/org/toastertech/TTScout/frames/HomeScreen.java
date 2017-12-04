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
        setupTeamLogo();
        add(title);

        setupButtonPanel();
        add(buttonPanel);

        repaint();
        revalidate();
    }

    private void setupTeamLogo(){
        File teamLogoFile = new File("src/org/toastertech/TTScout/res/ttlogo.png");
        System.out.println(teamLogoFile.exists());
        ImageIcon teamLogo = new ImageIcon(teamLogoFile.getPath());
        title.setIcon(teamLogo);

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
