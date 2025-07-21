import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class remove extends JFrame implements ActionListener {
    Choice ch;
    JButton delete,back;
    remove()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);



        JLabel lblempid=new JLabel("Emplyoee ID:");
        lblempid.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblempid.setBounds(100,75,120,40);
        add(lblempid);

        ch=new Choice();
        ch.setBounds(225,85,90,40);
        add(ch);

        try{
            conn connection=new conn();
            ResultSet rs=connection.s.executeQuery("select * from employee");
            while(rs.next())
            {
                ch.add(rs.getString(11));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        JLabel lblname=new JLabel("Name:");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblname.setBounds(100,140,75,40);
        add(lblname);

        JLabel labelname=new JLabel();
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelname.setBounds(175,140,200,40);
        add(labelname);

        JLabel lblemail=new JLabel("Email:");
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblemail.setBounds(100,180,75,40);
        add(lblemail);

        JLabel labelemail=new JLabel();
        labelemail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelemail.setBounds(175,180,200,40);
        add(labelemail);

        JLabel lblphone=new JLabel("Phone:");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblphone.setBounds(100,220,75,40);
        add(lblphone);

        JLabel labelphone=new JLabel();
        labelphone.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelphone.setBounds(175,220,200,40);
        add(labelphone);

        delete=new JButton("Delete");
        delete.setFont(new Font("arial", Font.PLAIN, 12));
        delete.setBounds(120,300,75,30);
        delete.addActionListener(this);
        add(delete);

        back=new JButton("Back");
        back.setFont(new Font("arial", Font.PLAIN, 12));
        back.setBounds(200,300,75,30);
        back.addActionListener(this);
        add(back);



        try{
            conn connection=new conn();
            String query="select * from employee where empID="+ch.getSelectedItem();
            ResultSet rs=connection.s.executeQuery(query);
            while(rs.next())
            {
                labelname.setText(rs.getString("name"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        ch.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try{
                    conn connection=new conn();
                    String query="select * from employee where empID="+ch.getSelectedItem();
                    ResultSet rs=connection.s.executeQuery(query);
                    while(rs.next())
                    {
                        labelname.setText(rs.getString("name"));
                        labelphone.setText(rs.getString("phone"));
                        labelemail.setText(rs.getString("email"));
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        setSize(800, 600);
        setLocation(275, 175);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==delete)
        {
            try{
                conn connection=new conn();
                String query="delete from employee where empID="+ch.getSelectedItem();
                connection.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee deleted successfully");
                setVisible(false);
                new home();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else {
            setVisible(false);
            new home();
        }
    }

    public static void main(String[] args) {
        new remove();
    }
}
