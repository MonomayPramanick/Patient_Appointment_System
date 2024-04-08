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
public class Login_admin extends JFrame implements ActionListener {
    JFrame f;
    JPanel p;
    JLabel l1,l2,l3,l4;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2;
    Login_admin(){
        f=new JFrame("Login Page");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
       
        
        l1=new JLabel();
        l1.setBounds(0,0,580,350);
        l1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("hospital/Icons/login.png"));
        Image i=img.getImage().getScaledInstance(580, 350, Image.SCALE_SMOOTH);
        ImageIcon i1=new ImageIcon(i);
        l1.setIcon(i1);
        
        
       l2=new JLabel("Login Page");
       l2.setBounds(190, 30, 500, 50);
       l2.setFont(new Font("Airal",Font.BOLD,30));
       l2.setForeground(Color.BLACK);
       l1.add(l2);
       
       l3=new JLabel("Username: ");
       l3.setBounds(130, 120, 150, 30);
       l3.setFont(new Font("Airal",Font.BOLD,20));
       l3.setForeground(Color.BLACK);
       l1.add(l3);
       
       l4=new JLabel("Password: ");
       l4.setBounds(130, 170, 150, 30);
       l4.setFont(new Font("Airal",Font.BOLD,20));
       l4.setForeground(Color.BLACK);
       l1.add(l4);
       
       t1=new JTextField();
       t1.setBounds(310,120,150,30);
       l1.add(t1);
       
       p1=new JPasswordField();
       p1.setBounds(310,170,150,30);
       l1.add(p1);
       
       b1=new JButton("Login");
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.WHITE);
       b1.setBounds(130,220,150,40);
       b2=new JButton("Back");
       b2.setBackground(Color.BLACK);
       b2.setForeground(Color.WHITE);
       b2.setBounds(310,220,150,40);
       
       l1.add(b1);
       l1.add(b2);
       
       b1.addActionListener(this);
       b2.addActionListener(this);
       
       f.add(l1);
       f.setVisible(true);
       f.setSize(580,350);
       f.setLocation(300,100);
       f.setResizable(false);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            f.setVisible(false);
            new Patient_Appointment_SYstem();
        }
        if(ae.getSource()==b1){
            try{
                Connectionclass obj=new Connectionclass();
                String name=t1.getText();
                String pass=p1.getText();
                
                String q="select * from admin where username='"+name+"'and password='"+pass+"'";
                ResultSet rs=obj.stm.executeQuery(q);
                if(rs.next()){
                    new AdminHomePage();
                    f.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "You have selected wrong username and password");
                    f.setVisible(false);
                    f.setVisible(true);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
  
    public static void main(String args[]){
        new Login_admin();
    }

}

