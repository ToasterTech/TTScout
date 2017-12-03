package org.toastertech.TTScout.frames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class HomeScreen extends JFrame implements ActionListener {
    JLabel title = new JLabel("Toaster Scout");

    JPanel buttonPanel = new JPanel(new FlowLayout());

    JButton oldFilesButton = new JButton("Select Saved Match");
    JButton newFileButton = new JButton("Create New Match");

    public HomeScreen(){
        System.out.println(new File(".").getAbsolutePath());
        //Handling the Basic Background
        setVisible(true); //Display
        setSize(600,400); //Screen Size - Should be Resizable
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));



        //Adding Components
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 40));
        add(title);

        setupButtonPanel();
        add(buttonPanel);
    }

    private void setupTeamLogo() throws Exception{
        //BufferedImage bufferedImage = ImageIO.read(this.getClass().getClassLoader().getResource("org/toastertech/TTScout/res/ttlogo.png"));
        //Image image = bufferedImage.getScaledInstance(400,400, Image.SCALE_SMOOTH);



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
