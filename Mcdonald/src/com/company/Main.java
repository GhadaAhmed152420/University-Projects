package com.company;

public class Main {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                Frames F = new Frames();
                F.frame1();

            }

        });
    }

}
