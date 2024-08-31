
package rmanagement;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddUser extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname, tffname, tfaddress, tfphone,  tfstatus, tfbg;
    JDateChooser dcdob;
    JComboBox cbwheel;
    JLabel lbluserId; 
    JButton add, back;
    
    AddUser() {
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Your Details For Driver's License Test");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("First Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel labelfname = new JLabel("Last Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
        
        JLabel vehtype = new JLabel("Vehicle Type");
        vehtype.setBounds(400, 200, 150, 30);
        vehtype.setFont(new Font("serif", Font.PLAIN, 20));
        add(vehtype);
        
        String courses[] = {"Four Wheeler", "Two wheeler"};
        cbwheel = new JComboBox(courses);
        cbwheel.setBackground(Color.WHITE);
        cbwheel.setBounds(600, 200, 150, 30);
        add(cbwheel);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Contact");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel labelstatus = new JLabel("Status");
        labelstatus.setBounds(50, 300, 150, 30);
        labelstatus.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelstatus);
        
        tfstatus = new JTextField();
        tfstatus.setBounds(200, 300, 150, 30);
        add(tfstatus);
        
        JLabel labelbg = new JLabel("Blood Group");
        labelbg.setBounds(50, 350, 150, 30);
        labelbg.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelbg);
        
        tfbg = new JTextField();
        tfbg.setBounds(200, 350, 150, 30);
        add(tfbg);
        
        
        JLabel labeluserId = new JLabel("User id");
        labeluserId.setBounds(400, 300, 150, 30);
        labeluserId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeluserId);
        
        lbluserId = new JLabel("" + number);
        lbluserId.setBounds(600, 300, 150, 30);
        lbluserId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbluserId);
        
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String F_NAME = tfname.getText();
            String L_NAME = tffname.getText();
            String DOB = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
           
            String ADDRESS = tfaddress.getText();
            String CONTACT = tfphone.getText();
            String TYPE = (String) cbwheel.getSelectedItem();
            String STATUS = tfstatus.getText();
            String BL_GP = tfbg.getText();
            String T_ID = lbluserId.getText();
            
            
            try {
                Conn conn = new Conn();
                String query = "insert into dl_test values('"+F_NAME+"', '"+L_NAME+"', '"+DOB+"', '"+ADDRESS+"', '"+CONTACT+"', '"+TYPE+"', '"+STATUS+"','"+BL_GP+"', '"+T_ID+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddUser();
    }
}
