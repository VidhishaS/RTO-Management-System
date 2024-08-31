package rmanagement;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class VehReg extends JFrame implements ActionListener {
    JTable table;
    Choice vehregId;
    JButton search, print, back;
    
    VehReg() {
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Vehicle registration number");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        vehregId = new Choice();
        vehregId.setBounds(180, 20, 150, 20);
        add(vehregId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from veh_reg");
            while(rs.next()) {
                vehregId.add(rs.getString("o_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from veh_reg");
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
            String query = "select * from veh_reg where reg_no = '"+vehregId.getSelectedItem()+"'";
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
        new VehReg();
    }
}

