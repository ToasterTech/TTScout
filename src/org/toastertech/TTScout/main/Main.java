package org.toastertech.TTScout.main;

import org.toastertech.TTScout.data.FileManager;
import org.toastertech.TTScout.frames.HomeScreen;


public class Main {

    public static void main(String[] args){
        FileManager.setupDirectory();

        new HomeScreen();
    }
}
