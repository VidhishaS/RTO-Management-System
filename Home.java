
package rmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

    JButton view, add, update, officers, reg, emtest,remove;
    
    Home() {
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/blue1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        JLabel heading = new JLabel("RTO Management System");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);
        
        add = new JButton("Add User");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View Users");
        view.setBounds(820, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update User");
        update.setBounds(650, 140, 150, 40);
        update.addActionListener(this);
        image.add(update);
        
        reg = new JButton("Vehicle Registration");
        reg.setBounds(650, 200, 150, 40);
        reg.addActionListener(this);
        image.add(reg);
        
        emtest = new JButton("Emmission Test");
        emtest.setBounds(820, 200, 150, 40);
        emtest.addActionListener(this);
        image.add(emtest);
        
//        remove = new JButton("Remove User");
//        remove.setBounds(650, 260, 150, 40);
//        remove.addActionListener(this);
//        image.add(remove);
        
        officers = new JButton("Officers");
        officers.setBounds(820, 140, 150, 40);
        officers.addActionListener(this);
        image.add(officers);
        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            AddUser addUser = new AddUser();
        } else if (ae.getSource() == view) {
            setVisible(false);
            ViewUser viewUser = new ViewUser();
        } else if (ae.getSource() == update) {
            setVisible(false);
            UpdateUser updateUser = new UpdateUser("");
        } else if (ae.getSource() == officers) {
            setVisible(false);
            ViewOfficer viewOfficer = new ViewOfficer();
        } else if (ae.getSource() == reg) {
            setVisible(false);
            VehReg vehReg = new VehReg();
        } else if (ae.getSource() == emtest) {
            setVisible(false);
            Emtest emTest = new Emtest();
        } else {
            setVisible(false);
            RemoveUser removeUser = new RemoveUser();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}