import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;
public class update extends JFrame implements ActionListener
{
    Random ran=new Random();
    int number=ran.nextInt(999999);

    JTextField tfeducation, name,fname,salary,address,phone,email,desi,adhar;
    JButton addbut,back;
    JDateChooser dobc;
    JComboBox cb;
    JLabel empid;
    String editid;
    public update(String editid)
    {
        this.editid=editid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel adddet=new JLabel("Update Employee Details");
        adddet.setFont(new Font("TAMOHA",Font.BOLD,25));
        adddet.setBounds(250,50,300,40);
        add(adddet);

        JLabel nme=new JLabel("Name:");
        nme.setFont(new Font("Tahoma",Font.PLAIN,17));
        nme.setBounds(100,120,50,20);
        add(nme);

        JLabel lblname=new JLabel();
        lblname.setBounds(150,120,200,20);
        add(lblname);

        JLabel fnme=new JLabel("Father's Name:");
        fnme.setFont(new Font("Tahoma",Font.PLAIN,17));
        fnme.setBounds(400,120,120,20);
        add(fnme);

        fname=new JTextField();
        fname.setBounds(520,120,200,20);
        add(fname);


        JLabel dob=new JLabel("D.O.B:");
        dob.setFont(new Font("Tahoma",Font.PLAIN,17));
        dob.setBounds(100,170,50,20);
        add(dob);

        JLabel lbldob=new JLabel();
        lbldob.setBounds(150,170,200,20);
        add(lbldob);

        JLabel sal=new JLabel("Salary:");
        sal.setFont(new Font("Tahoma",Font.PLAIN,17));
        sal.setBounds(460,170,100,20);
        add(sal);

        salary=new JTextField();
        salary.setBounds(520,170,200,20);
        add(salary);

        JLabel addr=new JLabel("Address:");
        addr.setFont(new Font("Tahoma",Font.PLAIN,17));
        addr.setBounds(85,220,100,20);
        add(addr);

        address=new JTextField();
        address.setBounds(150,220,200,20);
        add(address);

        JLabel ph=new JLabel("Phone:");
        ph.setFont(new Font("Tahoma",Font.PLAIN,17));
        ph.setBounds(460,220,70,20);
        add(ph);

        phone=new JTextField();
        phone.setBounds(520,220,200,20);
        add(phone);

        JLabel em=new JLabel("Email:");
        em.setFont(new Font("Tahoma",Font.PLAIN,17));
        em.setBounds(105,270,100,20);
        add(em);

        email=new JTextField();
        email.setBounds(151,270,200,20);
        add(email);

        JLabel high=new JLabel("Highest Education:");
        high.setFont(new Font("Tahoma",Font.PLAIN,17));
        high.setBounds(373,270,200,20);
        add(high);

        tfeducation=new JTextField();
        tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(520,270,200,20);
        add(tfeducation);

        JLabel des=new JLabel("Designation:");
        des.setFont(new Font("Tahoma",Font.PLAIN,17));
        des.setBounds(56,320,100,20);
        add(des);

        desi=new JTextField();
        desi.setBounds(151,320,200,20);
        add(desi);

        JLabel adha=new JLabel("Adhaar Number:");
        adha.setFont(new Font("Tahoma",Font.PLAIN,17));
        adha.setBounds(390,320,200,20);
        add(adha);

        JLabel lbladhar=new JLabel();
        lbladhar.setBounds(520,320,200,20);
        add(lbladhar);

        JLabel emp=new JLabel("Employee ID:");
        emp.setFont(new Font("Tahoma",Font.PLAIN,17));
        emp.setBounds(50,370,200,20);
        add(emp);

        empid=new JLabel();
        empid.setFont(new Font("Tahoma",Font.PLAIN,17));
        empid.setBounds(155,370,200,20);
        add(empid);

        try{
            conn connex=new conn();
            String query="select * from employee where empid= '"+editid+"'";
            ResultSet rs=connex.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                fname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("DOB"));
                salary.setText(rs.getString("salary"));
                address.setText(rs.getString("address"));
                phone.setText(rs.getString("phone"));
                email.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("highestEducation"));
                desi.setText(rs.getString("designation"));
                lbladhar.setText(rs.getString("AdhaarNumber"));
            empid.setText(rs.getString("empID"));}
        }catch(Exception ex){
            ex.printStackTrace();
        }

        addbut=new JButton("Update");
        addbut.setFont(new Font("Tahoma",Font.PLAIN,17));
        addbut.setBackground(Color.BLACK);
        addbut.setForeground(Color.WHITE);
        addbut.setBounds(280,420,100,30);
        addbut.addActionListener(this);
        add(addbut);

        back=new JButton("Back");
        back.setFont(new Font("Tahoma",Font.PLAIN,17));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(385,420,100,30);
        back.addActionListener(this);
        add(back);


        setSize(800, 600);
        setLocation(275, 175);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addbut)
        {
            String fathername = fname.getText();
            String salar=salary.getText();
            String adress=address.getText();
            String pho=phone.getText();
            String ema=email.getText();
            String desig=desi.getText();
            String highed=tfeducation.getText();
            try{
                conn connection=new conn();
                String query = "UPDATE employee SET fname = '"+fathername+"', salary='"+salar+"', address='"+adress+"', phone='"+pho+"', email='"+ema+"', highestEducation='"+highed+"', designation='"+desig+"' WHERE empID='"+editid+"'";

                connection.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                setVisible(false);
                new home();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            new home();

        }
    }
    public static void main(String[] args) {
        new update("");
    }
}
