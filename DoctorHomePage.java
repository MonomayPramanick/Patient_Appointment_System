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
import javax.swing.table.DefaultTableModel;

public class DoctorHomePage extends JFrame implements ActionListener {
    
    JFrame j;
    JLabel l1;
    JButton b1, b2, backButton;
    
    DoctorHomePage() {
        j = new JFrame("Doctor Home Page");

        l1 = new JLabel();
        b1 = new JButton("View Doctor");
        b2 = new JButton("View Patient");
       
        backButton = new JButton("Back");

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hospital/Icons/doctor.png"));
        Image i1 = img.getImage().getScaledInstance(800, 570, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        buttonPanel.setOpaque(false);
        b1.setPreferredSize(new Dimension(120, 30));
        b1.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        buttonPanel.add(b1);

        b2.setPreferredSize(new Dimension(120, 30));
        b2.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        buttonPanel.add(b2);

       
        j.add(buttonPanel, BorderLayout.NORTH);
        j.add(l1, BorderLayout.CENTER);

        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        backButtonPanel.setOpaque(false);
        backButtonPanel.add(backButton);
        j.add(backButtonPanel, BorderLayout.SOUTH);

        j.setSize(800, 570);
        j.setLocation(300, 100);
        j.setVisible(true);
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1.addActionListener(this);
        b2.addActionListener(this);
      
        backButton.addActionListener(this);
    }

   public void actionPerformed(ActionEvent e) {
    if(e.getSource()==b1){
        j.setVisible(false);
         JFrame tableFrame1 = new JFrame("Doctor Table");
        tableFrame1.setSize(800, 570);
        tableFrame1.setLocation(300, 100);
        tableFrame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a panel to hold the table
        JPanel tablePanel1 = new JPanel(new BorderLayout());
        tablePanel1.setPreferredSize(new Dimension(800, 520)); // Reduced height to accommodate buttons

        // Define the column names for the table
        String[] columnNames1 = {"DOCTOR_ID", "USER_Name","NAME", "Age","PHONE","CITY","EMAIL","GENDER","Specialization"};

        DefaultTableModel model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(columnNames1);

        // Create a table and set its model
        JTable table1 = new JTable();
        table1.setModel(model1);

        // Create a scroll pane for the table
        JScrollPane scrollPane11 = new JScrollPane(table1);

        // Add the scroll pane to the table panel
        tablePanel1.add(scrollPane11, BorderLayout.CENTER);

        // Add the table panel to the table frame
        tableFrame1.add(tablePanel1);
        tableFrame1.setVisible(true);

        // Create a panel for the buttons
        JPanel buttonPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel1.setPreferredSize(new Dimension(800, 50)); // Height for the buttons
        tablePanel1.add(buttonPanel1, BorderLayout.SOUTH);

        // Create the "Back" button
        JButton backButton1 = new JButton("Back");
        backButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle back button action, e.g., go back to the previous screen
                // You can use dispose() to close the current frame and return to the previous frame
                tableFrame1.dispose();
                
                new DoctorHomePage();
            }
        });
        buttonPanel1.add(backButton1);

        
        JButton add1 = new JButton("ADD");
        add1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle back button action, e.g., go back to the previous screen
                // You can use dispose() to close the current frame and return to the previous frame
                
                new ReceptionistRegister();
            }
        });
        buttonPanel1.add(add1);
        
        
        
        // Create the "Edit" button
        JButton editButton1 = new JButton("Edit");
        editButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle edit button action, e.g., allow editing of the selected row
                int selectedRow = table1.getSelectedRow();
                if (selectedRow != -1) {
                    // Assuming you have a method to handle editing of the selected row
                    // editSelectedRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to edit", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPanel1.add(editButton1);
        
        JButton addDoctor=new JButton("ADD Doctor");
        addDoctor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new DoctorRegister(); 
            }
        });

        try {
            Connectionclass obj1=new Connectionclass();

            String q1="select * from doctor";
            ResultSet rs1=obj1.stm.executeQuery(q1);

            // Iterate through the result set and add rows to the table model
            while (rs1.next()) {
                Object[] row = new Object[9]; // Assuming there are 9 columns in your table
                row[0] = rs1.getString("doctor_id");
                row[1] = rs1.getString("username");
                row[2] = rs1.getString("name");
                row[3] = rs1.getString("age");
                row[4] = rs1.getString("phone");
                row[5] = rs1.getString("city");
                row[6] = rs1.getString("email");
                row[7] = rs1.getString("gender");
                
                row[8]=rs1.getString("specialization");
                model1.addRow(row);
            }

            rs1.close();
            obj1.con.close();
        } catch (SQLException ae) {
            ae.printStackTrace();
        }
        
    }
    
    if(e.getSource()== backButton){
        j.setVisible(false);
        new Patient_Appointment_SYstem();
        
    }
    
    
    
    
    if(e.getSource()==b2){
        j.setVisible(false);
          JFrame tableFrame2= new JFrame("Patient Table");
        tableFrame2.setSize(800, 570);
        tableFrame2.setLocation(300, 100);
        tableFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a panel to hold the table
        JPanel tablePanel2 = new JPanel(new BorderLayout());
        tablePanel2.setPreferredSize(new Dimension(800, 520)); // Reduced height to accommodate buttons

        // Define the column names for the table
        String[] columnNames2 = {"Patient_ID", "USER_Name","NAME", "Age","PHONE","CITY","EMAIL","GENDER","Patient Problem","Doctor Name","Date"};

        DefaultTableModel model2 = new DefaultTableModel();
        model2.setColumnIdentifiers(columnNames2);

        // Create a table and set its model
        JTable table = new JTable();
        table.setModel(model2);

        // Create a scroll pane for the table
        JScrollPane scrollPane2 = new JScrollPane(table);

        // Add the scroll pane to the table panel
        tablePanel2.add(scrollPane2, BorderLayout.CENTER);

        // Add the table panel to the table frame
        tableFrame2.add(tablePanel2);
        tableFrame2.setVisible(true);

        // Create a panel for the buttons
        JPanel buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel2.setPreferredSize(new Dimension(800, 50)); // Height for the buttons
        tablePanel2.add(buttonPanel2, BorderLayout.SOUTH);

        // Create the "Back" button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle back button action, e.g., go back to the previous screen
                // You can use dispose() to close the current frame and return to the previous frame
                tableFrame2.dispose();
                new DoctorHomePage();
            }
        });
        buttonPanel2.add(backButton);

        JButton add2 = new JButton("ADD");
        add2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle back button action, e.g., go back to the previous screen
                // You can use dispose() to close the current frame and return to the previous frame
                
                new PatientRegister();
            }
        });
        buttonPanel2.add(add2);
        
        
        
     

        try {
            Connectionclass obj2=new Connectionclass();

            String q2="select * from patient";
            ResultSet rs2=obj2.stm.executeQuery(q2);

            // Iterate through the result set and add rows to the table model
            while (rs2.next()) {
                Object[] row = new Object[11]; // Assuming there are 9 columns in your table
                row[0] = rs2.getString("patient_id");
                row[1] = rs2.getString("username");
                row[2] = rs2.getString("name");
                row[3] = rs2.getString("age");
                row[4] = rs2.getString("phone");
                row[5] = rs2.getString("city");
                row[6] = rs2.getString("email");
                row[7] = rs2.getString("gender");
               
                row[8]=rs2.getString("problem");
                row[9]=rs2.getString("doctor_name");
                row[10]=rs2.getString("date");
                model2.addRow(row);
            }

            // Close the result set and connection
            rs2.close();
            obj2.con.close();
        } catch (SQLException ae) {
            ae.printStackTrace();
        }
    }
   } 
 
        

    public static void main(String args[]) {
        new DoctorHomePage();
    }

}
