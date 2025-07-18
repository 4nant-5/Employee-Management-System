import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home extends JFrame implements ActionListener {
    JButton ad,upd,vie,remo;
    public home() {


        JLabel operations = new JLabel("Operations");
        operations.setFont(new Font("TAMOHA", Font.BOLD, 20));
        operations.setBounds(420,100,200,30);
        add(operations);

        ad = new JButton("Add");
        ad.setBounds(350,150,100,30);
        ad.addActionListener(this);
        add(ad);

        upd = new JButton("Update");
        upd.setBounds(500,150,100,30);
        upd.addActionListener(this);
        add(upd);

        vie = new JButton("View");
        vie.setBounds(350,200,100,30);
        vie.addActionListener(this);
        add(vie);

        remo = new JButton("Remove");
        remo.setBounds(500,200,100,30);
        remo.addActionListener(this);
        add(remo);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1000, 500);
        setLocation(275, 175);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ad){
            setVisible(false);
            new addempoloyee();
        }
        else if(e.getSource()==upd){

        }
        else if(e.getSource()==vie){

        }
        else if(e.getSource()==remo){

        }
    }
    public static void main(String[] args) {
        new home();
    }
}
