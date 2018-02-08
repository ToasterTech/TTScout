package org.toastertech.TTScout.panels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class MultipleCheckboxPanel extends JPanel {

    JCheckBox[] checkBoxes;
    JLabel[]    checkBoxLabels;

    JPanel topPanel, bottomPanel;

    public MultipleCheckboxPanel(String title, String ... prompts){
        int arraySize = prompts.length;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        topPanel =    new JPanel(new GridLayout(1, arraySize));
        bottomPanel = new JPanel(new GridLayout(1, arraySize));



        checkBoxes     = new JCheckBox[arraySize];
        checkBoxLabels = new JLabel[arraySize];

        setBorder(BorderFactory.createTitledBorder(title));
        for(int i = 0; i < prompts.length; i++){
            checkBoxes[i]     = new JCheckBox();
            checkBoxLabels[i] = new JLabel(prompts[i]);

            checkBoxes[i]    .setHorizontalAlignment(JCheckBox.CENTER);
            checkBoxLabels[i].setHorizontalAlignment(JLabel.CENTER);

            topPanel   .add(checkBoxes[i]);
            bottomPanel.add(checkBoxLabels[i]);
        }


        add(topPanel);
        add(bottomPanel);

    }

    public int[] getResults(){
        int[] returnArray = new int[checkBoxes.length];

        for(int i = 0; i < returnArray.length; i++){
            returnArray[i] = (checkBoxes[i].isSelected()) ? 1 : 0;
        }

        return returnArray;
    }

}
