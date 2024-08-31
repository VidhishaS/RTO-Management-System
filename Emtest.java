
package rmanagement;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class Emtest extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tflvl, tfstatus, tfreg;
    JDateChooser dcdob;
    JLabel lbleId;
    JButton add, back;
    
    Emtest() {
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Emmission Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labellvl = new JLabel("Level");
        labellvl.setBounds(50, 150, 150, 30);
        labellvl.setFont(new Font("serif", Font.PLAIN, 20));
        add(labellvl);
        
        tflvl = new JTextField();
        tflvl.setBounds(200, 150, 150, 30);
        add(tflvl);
        
        JLabel labelstatus = new JLabel("Status");
        labelstatus.setBounds(400, 150, 150, 30);
        labelstatus.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelstatus);
        
        tfstatus = new JTextField();
        tfstatus.setBounds(600, 150, 150, 30);
        add(tfstatus);
        
        JLabel labeldob = new JLabel("Date of Test");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
        JLabel labelreg = new JLabel("Reg number");
        labelreg.setBounds(400, 200, 150, 30);
        labelreg.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelreg);
        
        tfreg = new JTextField();
        tfreg.setBounds(600, 200, 150, 30);
        add(tfreg);
        
        
        
        JLabel labeleId = new JLabel("Emmission id");
        labeleId.setBounds(400, 250, 150, 30);
        labeleId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleId);
        
        lbleId = new JLabel("" + number);
        lbleId.setBounds(600, 250, 150, 30);
        lbleId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbleId);
        
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
            String lvl = tflvl.getText();
            String stats = tfstatus.getText();
            String e_date = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
           
            String reg_no = tfreg.getText();
            String e_id = lbleId.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into emmission_t values('"+lvl+"', '"+stats+"', '"+e_date+"', '"+reg_no+"', '"+e_id+"')";
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
        new Emtest();
    }
}

