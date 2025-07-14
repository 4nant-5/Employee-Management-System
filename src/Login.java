import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setSize(1000, 500);
        setLocation(275, 175);
        setVisible(true);

        JLabel user = new JLabel("Username");
        setLayout(null);
        user.setFont(new Font("Times New Roman", Font.BOLD, 20));
        user.setBounds(250, 150, 100, 20);
        add(user);

        JTextField usn = new JTextField();
        usn.setBounds(375, 150, 200, 20);
        add(usn);

        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pass.setBounds(250, 200, 100, 20);
        add(pass);

        JTextField pas = new JTextField();
        pas.setBounds(375, 200, 200, 20);
        add(pas);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image img2 = img1.getImage().getScaledInstance(1000, 500, Image.SCALE_SMOOTH); // Changed size
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img4 = new JLabel(img3);
        img4.setBounds(0, 0, 1000, 500); // Matching size
        add(img4);


        JButton login = new JButton("Login");
        login.setFont(new Font("Times New Roman", Font.BOLD, 20));
        login.setBounds(375, 250, 200, 30);
        add(login);
    }
    public static void main(String[] args) {
        new Login();
    }
}
