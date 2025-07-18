import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField usn;
    JTextField pas;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1000, 500);
        setLocation(275, 175);

        JLabel user = new JLabel("Username");
        user.setFont(new Font("Times New Roman", Font.BOLD, 20));
        user.setBounds(250, 150, 100, 20);
        add(user);

        usn = new JTextField();  // ✅ Fixed
        usn.setBounds(375, 150, 200, 20);
        add(usn);

        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pass.setBounds(250, 200, 100, 20);
        add(pass);

        pas = new JTextField();
        pas.setBounds(375, 200, 200, 20);
        add(pas);

        JButton login = new JButton("Login");
        login.setFont(new Font("Times New Roman", Font.BOLD, 20));
        login.setBounds(375, 250, 200, 30);
        login.addActionListener(this);
        add(login);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image img2 = img1.getImage().getScaledInstance(1000, 500, Image.SCALE_SMOOTH);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img4 = new JLabel(img3);
        img4.setBounds(0, 0, 1000, 500);
        add(img4);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String username = usn.getText();
            String password = pas.getText();

            conn c = new conn();
            String query = "SELECT * FROM login WHERE username='" + username + "' AND password='" + password + "'";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login Successful");
                new home();
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
