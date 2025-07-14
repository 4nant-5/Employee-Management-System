import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Splash extends JFrame implements ActionListener {
    Splash()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel head=new JLabel("Emplyee Management System");

        head.setBounds(325,45,1200,60);
        head.setFont(new Font("Times New Roman",Font.BOLD,30));
        head.setForeground(Color.BLACK);
        add(head);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image img2=img1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel img4=new JLabel(img3);
        img4.setBounds(310,60,375,375);
        add(img4);

        JButton but=new JButton("Proceed to Login");
        but.setFont(new Font("Times New Roman",Font.BOLD,20));
        but.setBounds(370,400,250,50);
        but.setBackground(Color.WHITE);
        but.setForeground(Color.blue);
        but.addActionListener(this);
        add(but);
        setSize(1000,500);
        setLocation(275,175);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
        new Login();
    }
    public static void main(String args[]) {
        new Splash();
    }
}
