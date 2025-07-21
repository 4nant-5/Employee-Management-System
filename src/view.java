import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class view extends javax.swing.JFrame implements ActionListener {
    JTable table;
    Choice employeeid;
    JButton search,print,update,back;
    public view() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Search by Emplyoee ID:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(50,25,155,20);
        add(lblNewLabel);

        employeeid = new Choice();
        employeeid.setBounds(210,25,150,20);
        add(employeeid);

        search=new JButton("Search");
        search.setBounds(50,70,100,20);
        search.addActionListener(this);
        add(search);

        print=new JButton("Print");
        print.setBounds(155,70,100,20);
        print.addActionListener(this);
        add(print);

        update=new JButton("Update");
        update.setBounds(260,70,100,20);
        update.addActionListener(this);
        add(update);

        back=new JButton("Back");
        back.setBounds(365,70,100,20);
        back.addActionListener(this);
        add(back);

        try{
            conn connection = new conn();
            ResultSet rs=connection.s.executeQuery("select * from employee");
            while(rs.next()){
                employeeid.add(rs.getString(11));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{
            conn connection = new conn();
            ResultSet rs=connection.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,1000,400);
        add(scrollPane);


        setSize(1000, 500);
        setLocation(275, 175);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==search){
            String query1 = "select * from employee where empID = '" + employeeid.getSelectedItem() + "'";

            try{
                conn connection = new conn();
                ResultSet rs=connection.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }else if(ae.getSource()==print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==update){
            setVisible(false);
            new update(employeeid.getSelectedItem());
        }else{
            setVisible(false);
            new home();
        }
    }

    public static void main(String[] args) {
        new view();
    }
}
