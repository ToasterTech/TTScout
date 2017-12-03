package org.toastertech.TTScout.frames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class HomeScreen extends JFrame {
    JLabel logo = new JLabel();



    JPanel buttonPanel = new JPanel(new FlowLayout());

    public HomeScreen(){
        System.out.println(new File(".").getAbsolutePath());
        //Handling the Basic Background
        setVisible(true); //Display
        setSize(800,800); //Screen Size - Should be Resizable
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));




        setupButtonPanel();
        add(buttonPanel);

        try {
            setupTeamLogo();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        //Adding Components
        add(logo);
    }

    private void setupTeamLogo() throws Exception{
        BufferedImage bufferedImage = ImageIO.read(this.getClass().getClassLoader().getResource("org/toastertech/TTScout/res/ttlogo.png"));
        Image image = bufferedImage.getScaledInstance(400,400, Image.SCALE_SMOOTH);

        logo.setIcon(new ImageIcon(image));


    }

    private void setupButtonPanel(){
        JButton oldFilesButton, newFileButton;

        oldFilesButton = new JButton("Select Saved Match");
        newFileButton = new JButton("Create New Match");

        buttonPanel.add(oldFilesButton);
        buttonPanel.add(newFileButton);

        add(buttonPanel);
    }


}
