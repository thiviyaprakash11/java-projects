import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class login implements  ActionListener {

    JFrame d=new JFrame("LOGIN");
    JTable t1;
    JButton b3,b4,b1;
    JTextField te1;
    JPasswordField te2;
    JLabel l1,l2;

    login() {
        JLabel t1 = new JLabel("DIABETES STATUS MANAGER");
        t1.setBounds(30, 0, 1000, 100);
        t1.setFont(new Font("", Font.BOLD, 20));
        l1 = new JLabel("ID");
        l2 = new JLabel("PASSWORD");
        l1.setBounds(140, 75, 100, 70);
        l1.setFont(new Font("", Font.PLAIN, 20));
        l2.setBounds(60, 135, 300, 70);
        l2.setFont(new Font("", Font.PLAIN, 20));
        d.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Gokul\\Desktop\\im.jpg")));

        te1 = new JTextField();
        te2 = new JPasswordField();
        te1.setBounds(175, 80, 200, 50);
        te2.setBounds(175, 140, 200, 50);

        te1.setFont(new Font("", Font.PLAIN, 20));
        te2.setFont(new Font("", Font.PLAIN, 20));
        b3 = new JButton("LOGIN");
        b4 = new JButton("NEW USER");
        b3.setFont(new Font("", Font.PLAIN, 20));
        b4.setFont(new Font("", Font.PLAIN, 20));
        b1 = new JButton("ADMIN");
        b1.setFont(new Font("", Font.PLAIN, 20));
        b3.setBounds(100, 205, 100, 50);
        b4.setBounds(225, 205, 100, 50);
        b1.setBounds(350, 205, 100, 50);
        b1.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        d.add(b3);
        d.add(b4);
        d.add(te1);
        d.add(te2);
        d.add(b1);
        d.add(l1);
        d.add(l2);
        d.add(t1);
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        d.setLayout(null);
        d.setVisible(true);
        d.setBounds(800,400,500,350);

        //d.setSize(500, 350);
        ImageIcon image = new ImageIcon("images(1).jpg");
        d.setIconImage(image.getImage());




    }
    public void mes()
    {
        JOptionPane ji = new JOptionPane("entered password is worn ");
        d.add(ji);
    }
    public void  actionPerformed(ActionEvent e)
    {
        Connection con;
        Statement st1, st2,st11,st12;
        ResultSet rs;
        if (e.getSource()==b1)
        {
            boolean d;
            String b,b2,b3 = null;
            b= te1.getText();
            System.out.println(b);

            b2=te2.getText();
            System.out.println(b2);

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/id ", "root", "root");
                String query1="select name from admin where id ='"+b+"'";
                st11 = con.createStatement();
                rs= st11.executeQuery(query1);
                while( rs.next()) {
                    b3= rs.getNString(1);;
                }
            }
            catch(Exception ex)
            {
                System.out.println("jfdnjsf");
                System.out.println(ex);
            }
            System.out.println(b2);
            d=b3.equalsIgnoreCase(b2);
            if (d==true) {
                admin ad = new admin();
            }
            else
            {
                mes();
            }
        }
        if(e.getSource()==b3)
        {
            boolean d;
            String b,b2,b3 = null;
            b= te1.getText();
            int as= Integer.parseInt(b);
            b2=te2.getText();
            System.out.println(b2);

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/id ", "root", "root");
                String query1="select name from details where id ='"+as+"'";
                st11 = con.createStatement();
                rs= st11.executeQuery(query1);
                while( rs.next()) {
                    b3= rs.getNString(1);;
                }
            }
            catch(Exception ex)
            {

                           }
            d=b3.equalsIgnoreCase(b2);
            if (d==true)
            {
            old_user old=new old_user(b);
        }
            else
            {
                JOptionPane.showMessageDialog(null ,"THE PASSWORD OR USER ID IS INVALID");

            }
        }
        if(e.getSource()==b4)
        {

            new_user new1=new new_user();

        }
    }
}

