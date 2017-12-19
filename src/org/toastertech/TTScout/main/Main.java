package org.toastertech.TTScout.main;

import org.toastertech.TTScout.data.FileManager;
import org.toastertech.TTScout.frames.HomeScreen;

import javax.swing.*;


public class Main {

    public static void main(String[] args){

        try {
            FileManager.setupDirectory();
        } catch (Exception e){
            JOptionPane.showConfirmDialog(new JDialog(), e.getMessage());
        }

        new HomeScreen();
    }
}
