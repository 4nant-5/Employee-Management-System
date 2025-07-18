import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class addempoloyee extends JFrame implements ActionListener
{
    Random ran=new Random();
            int number=ran.nextInt(999999);

    JTextField name,fname,salary,address,phone,email,desi,adhar;
    JButton addbut,back;
    JDateChooser dobc;
    JComboBox cb;
    JLabel empid;
    public addempoloyee()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel adddet=new JLabel("Add Employee Details");
        adddet.setFont(new Font("TAMOHA",Font.BOLD,25));
        adddet.setBounds(250,50,300,40);
        add(adddet);

        JLabel nme=new JLabel("Name:");
        nme.setFont(new Font("Tahoma",Font.PLAIN,17));
        nme.setBounds(100,120,50,20);
        add(nme);

        name=new JTextField();
        name.setBounds(150,120,200,20);
        add(name);

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

        dobc=new JDateChooser();
        dobc.setBounds(150,170,200,20);
        add(dobc);

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

        String []course={"BBA","BCA","B.TECH","MBA","MCA","M.TECH","PHd"};
        cb=new JComboBox(course);
        cb.setBackground(Color.WHITE);
        cb.setBounds(520,270,200,20);
        add(cb);

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

        adhar=new JTextField();
        adhar.setBounds(520,320,200,20);
        add(adhar);

        JLabel emp=new JLabel("Employee ID:");
        emp.setFont(new Font("Tahoma",Font.PLAIN,17));
        emp.setBounds(50,370,200,20);
        add(emp);

        empid=new JLabel(""+number);
        empid.setFont(new Font("Tahoma",Font.PLAIN,17));
        empid.setBounds(155,370,200,20);
        add(empid);

        addbut=new JButton("Add");
        addbut.setFont(new Font("Tahoma",Font.PLAIN,17));
        addbut.setBackground(Color.BLACK);
        addbut.setForeground(Color.WHITE);
        addbut.setBounds(275,420,85,30);
        addbut.addActionListener(this);
        add(addbut);

        back=new JButton("Back");
        back.setFont(new Font("Tahoma",Font.PLAIN,17));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(380,420,85,30);
        back.addActionListener(this);
        add(back);


        setSize(800, 600);
        setLocation(275, 175);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addbut)
        {
            String namee=name.getText();
            String fathername = fname.getText();
            String dateofbirth= ((JTextField)dobc.getDateEditor().getUiComponent()).getText();
            String salar=salary.getText();
            String adress=address.getText();
            String pho=phone.getText();
            String ema=email.getText();
            String desig=desi.getText();
            String adhaa=adhar.getText();
            String highed=(String)cb.getSelectedItem();
            String emplid=empid.getText();
            try{
                conn connection=new conn();
                String query="insert into employee values('"+namee+"','"+fathername+"','"+dateofbirth+"','"+salar+"','"+adress+"','"+pho+"','"+ema+"','"+highed+"','"+desig+"','"+adhaa+"','"+emplid+"' )";
                connection.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Added Successfully");
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
        new addempoloyee();
    }
}
