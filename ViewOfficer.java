package rmanagement;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class ViewOfficer extends JFrame implements ActionListener {
    JTable table;
    Choice cofficerId;
    JButton search, print, back;
    
    ViewOfficer() {
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Officer Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        cofficerId = new Choice();
        cofficerId.setBounds(180, 20, 150, 20);
        add(cofficerId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from officers");
            while(rs.next()) {
                cofficerId.add(rs.getString("o_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from officers");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        
        back = new JButton("Back");
        back.setBounds(220, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from officers where o_id = '"+cofficerId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewOfficer();
    }
}
