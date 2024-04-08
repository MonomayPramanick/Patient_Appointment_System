/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author monom
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Patient_Appointment_SYstem extends JFrame implements ActionListener {
    JFrame jf;
    JLabel l1, l2, l3;
    JButton b1, b2, b3, b4, exitButton; // Added exitButton
    Patient_Appointment_SYstem() {
        jf = new JFrame("Index Page");
        jf.getContentPane().setBackground(Color.WHITE);
        jf.setLayout(new BorderLayout());

        l1 = new JLabel();
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hospital/Icons/index2.png"));
        Image i1 = img.getImage().getScaledInstance(800, 570, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);

        l1.setIcon(img1);
        jf.add(l1, BorderLayout.CENTER);

        l2 = new JLabel("Online Patient Appointment System");
        l2.setBounds(50, 300, 600, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 30)); // Corrected the font name
        l2.setForeground(Color.BLACK);
        l1.add(l2);

        b1 = new JButton("Doctor");
        b1.setBounds(50, 390, 150, 40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        l1.add(b1);

        b2 = new JButton("Patient");
        b2.setBounds(220, 390, 150, 40);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        l1.add(b2);

        b3 = new JButton("Receptionist");
        b3.setBounds(50, 450, 150, 40);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        l1.add(b3);

        b4 = new JButton("Admin");
        b4.setBounds(220, 450, 150, 40);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        l1.add(b4);

        exitButton = new JButton("Exit"); // Added Exit button
        exitButton.setBackground(Color.WHITE);
        exitButton.setForeground(Color.BLACK);
        jf.add(exitButton, BorderLayout.SOUTH); // Added Exit button to SOUTH position

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        exitButton.addActionListener(this); 

        jf.setSize(800, 570);
        jf.setLocation(300, 100);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            jf.setVisible(false);
            new Login_Doctor();
        }
        if (ae.getSource() == b2) {
            jf.setVisible(false);
            new Login_Patient();
        }
        if (ae.getSource() == b3) {
            jf.setVisible(false);
            new Login_receptionist();
        }
        if (ae.getSource() == b4) {
            jf.setVisible(false);
            new Login_admin();
        }
        if (ae.getSource() == exitButton) { 
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        new Patient_Appointment_SYstem();
    }
}
