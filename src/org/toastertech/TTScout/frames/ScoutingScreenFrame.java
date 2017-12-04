package org.toastertech.TTScout.frames;

import org.toastertech.TTScout.data.Match;

import javax.swing.*;

public class ScoutingScreenFrame extends JFrame{

    public ScoutingScreenFrame(Match match){
            setSize(800, 800);
            setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
            setVisible(true);


    }

}
