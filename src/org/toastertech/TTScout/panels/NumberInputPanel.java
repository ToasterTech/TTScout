package org.toastertech.TTScout.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberInputPanel extends JPanel implements ActionListener {
    JButton    subtract1Button, add1Button;
    JTextField numericalTextField;

    String commandEnder;
    public NumberInputPanel(String title, String commandName, int defaultValue){
        setLayout(new GridLayout(1, 3, 1, 1));
        //setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        commandEnder = commandName;

        subtract1Button = new JButton("Subtract 1 " + commandName);
        add1Button      = new JButton("Add 1 " + commandName);

        numericalTextField = new JTextField((String.valueOf(defaultValue)), 1);
        numericalTextField.setEditable(false);
        setBorder(BorderFactory.createTitledBorder(title));

        add(subtract1Button);
        add(numericalTextField);
        add(add1Button);

        subtract1Button.addActionListener(this);
        add1Button.addActionListener(this);


    }

    public void setValue(int number){
        numericalTextField.setText(String.valueOf(number));
    }

    public int getValue(){
        return Integer.valueOf(numericalTextField.getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Subtract 1 " + commandEnder)){
            numericalTextField.setText(String.valueOf(Integer.valueOf(numericalTextField.getText()) - 1));
        } else if(e.getActionCommand().equals("Add 1 " + commandEnder)){
            numericalTextField.setText(String.valueOf(Integer.valueOf(numericalTextField.getText()) + 1));
        }
    }
}
