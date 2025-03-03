package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.Objects;

public class Frames implements Interface {

    @Override
    public void frame1() {
        JFrame f1 = new JFrame("McDonald`s");
        f1.setSize(600, 500);
        f1.setLayout(null);
        f1.setVisible(true);
        JPanel pp = new JPanel();
        pp.setBackground(Color.BLACK);
        pp.setBounds(0, 0, 600, 110);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/Mcc.png"))));
        pp.add(label);
        JLabel text = new JLabel("Welcome");
        text.setForeground(Color.white);
        text.setFont(new Font("Helvetica Neue", Font.BOLD, 50));
        pp.add(text);
        f1.add(pp);
        JPanel pp1 = new JPanel();
        pp1.setBackground(Color.ORANGE);
        pp1.setLayout(null);
        pp1.setBounds(0, 110, 600, 270);


        JLabel t1 = new JLabel("Name : ");
        t1.setBounds(10,20,100,25);
        t1.setForeground(Color.black);
        t1.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        JTextField txt1 = new JTextField();
        txt1.setBounds(220, 20, 200, 25);
        pp1.add(t1);
        pp1.add(txt1);

        JLabel t2 = new JLabel("Address : ");
        t2.setBounds(10,80,100,25);
        t2.setForeground(Color.black);
        t2.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        JTextField txt2 = new JTextField();
        txt2.setBounds(220, 80, 200, 25);
        pp1.add(t2);
        pp1.add(txt2);

        JLabel t3 = new JLabel("Email : ");
        t3.setBounds(10,140,100,25);
        t3.setForeground(Color.black);
        t3.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        JTextField txt3 = new JTextField();
        txt3.setBounds(220,140,200,25);
        pp1.add(t3);
        pp1.add(txt3);

        f1.add(pp1);
        JPanel pp2 = new JPanel();
        pp2.setBackground(Color.BLACK);
        pp2.setLayout(null);
        pp2.setBounds(0, 380, 600, 120);
        JButton btn = new JButton("Next");
        btn.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        btn.setBounds(250, 17, 100, 50);
        btn.setBackground(Color.RED);
        btn.setForeground(Color.WHITE);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   PrintWriter f = new PrintWriter("Data(1).txt");
                    f.println("name : "+ txt1.getText());
                    f.println("Address : "+ txt2.getText());
                    f.println("Email : "+ txt3.getText());
                    f.println("***********************************************");
                    f.close();
                } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null,ex);
                }
                f1.dispose();
                Frames ff = new Frames();
                ff.frame2();
            }
        });

        pp2.add(btn);
        f1.add(pp2);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLocationRelativeTo(null);
        f1.setResizable(false);
        f1.setVisible(true);
    }
    @Override
    public  void frame2(){
        JFrame f2 = new JFrame("McDonald`s");
        f2.setSize(700, 830);
        f2.setLayout(null);
        f2.setVisible(true);
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        p.setBounds(0, 0, 700, 110);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/mac.png"))));
        p.add(label);
        JLabel text = new JLabel("Questionnaire");
        text.setForeground(Color.white);
        text.setFont(new Font("Helvetica Neue", Font.BOLD, 50));
        p.add(text);
        f2.add(p);
        JPanel p1 = new JPanel();
        p1.setBounds(0, 110, 700, 600);
        p1.setBackground(Color.ORANGE);
        p1.setLayout(null);


        JLabel t1 = new JLabel("How do you see the hygiene in the restaurant ?");
        t1.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        t1.setBounds(10, 10, 600, 24);
        p1.add(t1);
        JRadioButton b1 = new JRadioButton("Excellent");
        p1.add(b1);
        b1.setBackground(Color.ORANGE);
        b1.setBounds(10, 40, 100, 14);
        b1.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        JRadioButton b2 = new JRadioButton("Good");
        p1.add(b2);
        b2.setBackground(Color.ORANGE);
        b2.setBounds(10, 55, 100, 14);
        b2.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        JRadioButton b3 = new JRadioButton("Bad");
        p1.add(b3);
        b3.setBackground(Color.ORANGE);
        b3.setBounds(10, 70, 100, 14);
        b3.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        ButtonGroup bb = new ButtonGroup();
        bb.add(b1);
        bb.add(b2);
        bb.add(b3);


        JLabel t2 = new JLabel("How do you see food ?");
        t2.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        t2.setBounds(10, 90, 600, 24);
        p1.add(t2);
        JRadioButton b4 = new JRadioButton("Excellent");
        p1.add(b4);
        b4.setBackground(Color.ORANGE);
        b4.setBounds(10, 120, 100, 14);
        b4.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        JRadioButton b5 = new JRadioButton("Good");
        p1.add(b5);
        b5.setBackground(Color.ORANGE);
        b5.setBounds(10, 135, 100, 14);
        b5.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        JRadioButton b6 = new JRadioButton("Bad");
        p1.add(b6);
        b6.setBackground(Color.ORANGE);
        b6.setBounds(10, 150, 100, 14);
        b6.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        ButtonGroup bb1 = new ButtonGroup();
        bb1.add(b4);
        bb1.add(b5);
        bb1.add(b6);


        JLabel t3 = new JLabel("How do you see the service in the restaurant ?");
        t3.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        t3.setBounds(10, 170, 600, 24);
        p1.add(t3);
        JRadioButton b7 = new JRadioButton("Excellent");
        p1.add(b7);
        b7.setBackground(Color.ORANGE);
        b7.setBounds(10, 200, 100, 14);
        b7.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        JRadioButton b8 = new JRadioButton("Good");
        p1.add(b8);
        b8.setBackground(Color.ORANGE);
        b8.setBounds(10, 215, 100, 14);
        b8.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        JRadioButton b9 = new JRadioButton("Bad");
        p1.add(b9);
        b9.setBackground(Color.ORANGE);
        b9.setBounds(10, 230, 100, 14);
        b9.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        ButtonGroup bb2 = new ButtonGroup();
        bb2.add(b7);
        bb2.add(b8);
        bb2.add(b9);


        JLabel t4 = new JLabel("How do you see the prices in the restaurant ?");
        t4.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        t4.setBounds(10, 250, 600, 24);
        p1.add(t4);
        JRadioButton b10 = new JRadioButton("Excellent");
        p1.add(b10);
        b10.setBackground(Color.ORANGE);
        b10.setBounds(10, 280, 100, 14);
        b10.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        JRadioButton b11 = new JRadioButton("Good");
        p1.add(b11);
        b11.setBackground(Color.ORANGE);
        b11.setBounds(10, 295, 100, 14);
        b11.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        JRadioButton b12 = new JRadioButton("Bad");
        p1.add(b12);
        b12.setBackground(Color.ORANGE);
        b12.setBounds(10, 310, 100, 14);
        b12.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        ButtonGroup bb3 = new ButtonGroup();
        bb3.add(b10);
        bb3.add(b11);
        bb3.add(b12);


        JLabel t5 = new JLabel("How do you see the location of the restaurant for you ?");
        t5.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        t5.setBounds(10, 330, 600, 24);
        p1.add(t5);
        JRadioButton b13 = new JRadioButton("Excellent");
        p1.add(b13);
        b13.setBackground(Color.ORANGE);
        b13.setBounds(10, 360, 100, 14);
        b13.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        JRadioButton b14 = new JRadioButton("Good");
        p1.add(b14);
        b14.setBackground(Color.ORANGE);
        b14.setBounds(10, 375, 100, 14);
        b14.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        JRadioButton b15 = new JRadioButton("Bad");
        p1.add(b15);
        b15.setBackground(Color.ORANGE);
        b15.setBounds(10, 390, 100, 14);
        b15.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        ButtonGroup bb4 = new ButtonGroup();
        bb4.add(b13);
        bb4.add(b14);
        bb4.add(b15);


        JLabel t6 = new JLabel("What do you think of our restaurant ?");
        t6.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        t6.setBounds(10, 410, 600, 24);
        p1.add(t6);
        JRadioButton b16 = new JRadioButton("Excellent");
        p1.add(b16);
        b16.setBackground(Color.ORANGE);
        b16.setBounds(10, 440, 100, 14);
        b16.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        JRadioButton b17 = new JRadioButton("Good");
        p1.add(b17);
        b17.setBackground(Color.ORANGE);
        b17.setBounds(10, 455, 100, 14);
        b17.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        JRadioButton b18 = new JRadioButton("Bad");
        p1.add(b18);
        b18.setBackground(Color.ORANGE);
        b18.setBounds(10, 470, 100, 14);
        b18.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        ButtonGroup bb5 = new ButtonGroup();
        bb5.add(b16);
        bb5.add(b17);
        bb5.add(b18);


        JLabel t7 = new JLabel("Put suggestions and complaints : ");
        t7.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        t7.setBounds(10, 510, 600, 24);
        p1.add(t7);
        JTextField tx = new JTextField();
        tx.setBounds(10, 540, 600, 40);
        p1.add(tx);
        f2.add(p1);
        JPanel p2 = new JPanel();
        p2.setBackground(Color.BLACK);
        p2.setLayout(null);
        p2.setBounds(0, 710, 700, 110);
        JButton btn = new JButton("Send");
        btn.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        btn.setBounds(300, 20, 100, 50);
        btn.setBackground(Color.RED);
        btn.setForeground(Color.WHITE);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PrintWriter f = new PrintWriter("Data(2).txt");
                    f.println("How do you see the hygiene in the restaurant ?");
                    if(b1.isSelected())
                        f.println("Very good");
                    else if(b2.isSelected())
                        f.println("Good");
                    else
                        f.println("Bad");

                    f.println("How do you see food ?");
                    if(b4.isSelected())
                        f.println("Very good");
                    else if(b5.isSelected())
                        f.println("Good");
                    else
                        f.println("Bad");

                    f.println("How do you see the service in the restaurant ?");
                    if(b7.isSelected())
                        f.println("Very good");
                    else if(b8.isSelected())
                        f.println("Good");
                    else
                        f.println("Bad");

                    f.println("How do you see the prices in the restaurant ?");
                    if(b10.isSelected())
                       f.println("Very good");
                    else if(b11.isSelected())
                        f.println("Good");
                    else
                       f.println("Bad");

                    f.println("How do you see the location of the restaurant for you ?");
                    if(b13.isSelected())
                       f.println("Very good");
                    else if(b14.isSelected())
                        f.println("Good");
                    else
                        f.println("Bad");

                   f.println("What do you think of our restaurant ?");
                    if(b16.isSelected())
                       f.println("Very good");
                    else if(b17.isSelected())
                        f.println("Good");
                    else
                       f.println("Bad");
                   f.println("****************************************************");
                    f.println("Put suggestions and complaints : "+tx.getText());
                    f.println("****************************************************");
                    f.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex);
                }
                f2.dispose();
                Frames ff = new Frames();
                ff.frame3();
            }

        });
        p2.add(btn);
        f2.add(p2);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setLocationRelativeTo(null);
        f2.setResizable(false);
    }

    @Override
    public void frame3() {
        JFrame f3 = new JFrame("McDonald`s");
        f3.setSize(550, 400);
        f3.setLayout(null);
        f3.setVisible(true);
        JPanel p = new JPanel();
        p.setBackground(Color.ORANGE);
        p.setBounds(0, 0, 550, 300);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/images/potato.png"))));
        p.add(label);
        JPanel p2 = new JPanel();
        JButton btn2 = new JButton("Close");
        p2.setBackground(Color.ORANGE);
        p2.setLayout(null);
        p2.setBounds(0, 300, 550, 100);
        btn2.setBackground(Color.RED);
        btn2.setForeground(Color.WHITE);
        btn2.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        btn2.setBounds(225,12,100,40);
        p2.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        f3.add(p2);
        JLabel text = new JLabel("Thank you for giving us your opinion.");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        p.add(text);
        f3.add(p);

        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f3.setLocationRelativeTo(null);
        f3.setResizable(false);
    }
}