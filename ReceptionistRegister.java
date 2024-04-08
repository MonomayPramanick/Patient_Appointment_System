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
import java.sql.*;
public class ReceptionistRegister extends JFrame implements ActionListener{
     JFrame f;
    JPanel p;
    JLabel l, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14;
    JTextField t1, t2, t3, t4, t5, t7, t8, t9, t10, t11;
    JPasswordField p1;
    JButton b1, b2;
    JComboBox<String> genderCombo;
    JTextArea t6;

    ReceptionistRegister() {
        f = new JFrame("Receptionist Registration");
        f.setLayout(null);
        l = new JLabel();
        l.setBounds(0, 0, 700, 750);
        l.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hospital/Icons/Patient_Reg.jpg"));
        Image i = img.getImage().getScaledInstance(700, 750, Image.SCALE_SMOOTH);
        ImageIcon i1 = new ImageIcon(i);
        l.setIcon(i1);

        l1 = new JLabel("Receptionist Registration Form");
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l1.setBounds(100, 30, 400, 30);
        l.add(l1);

        l2 = new JLabel("Name:");
        l2.setBounds(100, 70, 200, 30);
        l.add(l2);

        t1 = new JTextField();
        t1.setBounds(250, 70, 200, 30);
        l.add(t1);

        l3 = new JLabel("Receptionist-ID:");
        l3.setBounds(100, 110, 200, 30);
        l.add(l3);

        t2 = new JTextField();
        t2.setBounds(250, 110, 200, 30);
        l.add(t2);

        l4 = new JLabel("Username:");
        l4.setBounds(100, 150, 200, 30);
        l.add(l4);

        t3 = new JTextField();
        t3.setBounds(250, 150, 200, 30);
        l.add(t3);

        l5 = new JLabel("City:");
        l5.setBounds(100, 190, 200, 30);
        l.add(l5);

        t4 = new JTextField();
        t4.setBounds(250, 190, 200, 30);
        l.add(t4);

        l6 = new JLabel("Email:");
        l6.setBounds(100, 230, 200, 30);
        l.add(l6);

        t5 = new JTextField();
        t5.setBounds(250, 230, 200, 30);
        l.add(t5);

        l7 = new JLabel("Gender:");
        l7.setBounds(100, 270, 200, 30);
        l.add(l7);

        String[] genders = {"Male", "Female", "Other"};
        genderCombo = new JComboBox<>(genders);
        genderCombo.setBounds(250, 270, 200, 30);
        l.add(genderCombo);

        l8 = new JLabel("Phone:");
        l8.setBounds(100, 310, 200, 30);
        l.add(l8);

        t7 = new JTextField();
        t7.setBounds(250, 310, 200, 30);
        l.add(t7);

        l9 = new JLabel("Age:");
        l9.setBounds(100, 350, 200, 30);
        l.add(l9);

        t8 = new JTextField();
        t8.setBounds(250, 350, 200, 30);
        l.add(t8);

        l10 = new JLabel("Password:");
        l10.setBounds(100, 390, 200, 30);
        l.add(l10);

        p1 = new JPasswordField();
        p1.setBounds(250, 390, 200, 30);
        l.add(p1);

       

        b1 = new JButton("Register");
        b1.setBounds(150, 590, 100, 30); 
        b1.addActionListener(this);
        l.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(300, 590, 100, 30);
        b2.addActionListener(this);
        l.add(b2);

        f.add(l);
        f.setVisible(true);
        f.setSize(700, 750);
        f.setLocation(300, 100);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

   public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b1) {
        String name = t1.getText();
        String id = t2.getText();
        String username = t3.getText();
        String city = t4.getText();
        String email = t5.getText();
        String gender = (String) genderCombo.getSelectedItem();
        String phone = t7.getText();
        String age = t8.getText();
        String password = String.valueOf(p1.getPassword());
       

        try {
            Connectionclass obj = new Connectionclass();
            
            // Check if the ID already exists in the 'patients' table
            String idCheckQuery = "SELECT * FROM receptionist WHERE receptionist_id = '" + id + "'";
            ResultSet rs = obj.stm.executeQuery(idCheckQuery);
            if (rs.next()) {
                JOptionPane.showMessageDialog(f, "Receptionist ID already exists. Registration failed.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method
            }

            // Perform database operations to register the patient
            String query = "INSERT INTO receptionist (name, receptionist_id, username, city, email, gender, phone, age, password) "
                    + "VALUES ('" + name + "', '" + id + "', '" + username + "', '" + city + "', '" + email + "', '" + gender + "', '" + phone + "', '" + age + "', '" + password + "')";
            int rowsAffected = obj.stm.executeUpdate(query);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(f, "Registration successful");
                f.dispose();
               
            } else {
                JOptionPane.showMessageDialog(f, "Registration failed", "Error", JOptionPane.ERROR_MESSAGE);
               
                new ReceptionistRegister();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    } else if (e.getSource() == b2) {
        f.dispose();
        
    }
}

    

    public static void main(String args[]) {
        new ReceptionistRegister();
    }
}


