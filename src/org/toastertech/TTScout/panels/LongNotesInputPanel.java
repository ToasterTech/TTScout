package org.toastertech.TTScout.panels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LongNotesInputPanel extends JPanel {
    JTextArea mainInputArea;


    public LongNotesInputPanel(int rows, int cols, String title){
        setLayout(new FlowLayout());


        mainInputArea = new JTextArea(rows, cols);
        //mainInputArea = new JTextArea();
        mainInputArea.setFont(new Font(mainInputArea.getFont().getName(), mainInputArea.getFont().getStyle(), 20));
        mainInputArea.setLineWrap(true);
        setBorder(BorderFactory.createTitledBorder(title));

        add(new JScrollPane(mainInputArea));

    }

    public String getText(){
        return mainInputArea.getText();
    }

    public void setText(String text){
        mainInputArea.setText(text);
    }

}
