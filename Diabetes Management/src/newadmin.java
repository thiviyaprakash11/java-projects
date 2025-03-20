import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.*;

public class newadmin implements ActionListener {
    JTextField t11, t12, t13, t14, t15;
    JLabel l11, l12, l13, l14, l15;
    JLabel t1;

JFrame z;
Image im1;
    JButton h1,b1;
newadmin()  {

    b1=new JButton(""){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(im1, 0, 0, null);
            g.setColor(Color.WHITE);
            g.setFont(new Font("",Font.PLAIN,23));
            g.drawString("Submit", 160, 25);
        }
    };
    b1.setBounds(30,425,400,40);
    b1.setFocusPainted(false);
    b1.setBorderPainted(false);
    b1.setContentAreaFilled(false);
    b1.addActionListener(this);

    JFrame z=new JFrame("admin");
    t1 = new JLabel("DIABETES STATUS MANAGER");
    t1.setBounds(690, 50, 1000, 100);
    t1.setFont(new Font("", Font.BOLD, 40));
    t11 = new JTextField("a");
    t11.setBounds(950, 200, 200, 70);
    t12 = new JTextField("b");
    t12.setBounds(950, 325, 200, 70);
    t13 = new JTextField("c");
    t13.setBounds(950, 450, 200, 70);
    t14 = new JTextField("d");
    t14.setBounds(950, 575, 200, 70);
    t15 = new JTextField("e");
    t15.setBounds(950, 700, 200, 70);

    l11 = new JLabel("NAME");
    l11.setBounds(750, 200, 100, 70);
    l11.setFont(new Font("", Font.PLAIN, 30));
    l12 = new JLabel("AGE");
    l12.setBounds(750, 325, 100, 70);
    l12.setFont(new Font("", Font.PLAIN, 30));
    l13 = new JLabel("ID");
    l13.setBounds(750, 450, 100, 70);
    l13.setFont(new Font("", Font.PLAIN, 30));
    l14 = new JLabel("GENDER ");
    l14.setBounds(750, 575, 200, 70);
    l14.setFont(new Font("", Font.PLAIN, 30));
    l15 = new JLabel("D O B");
    l15.setBounds(750, 700, 100, 70);
    l15.setFont(new Font("", Font.PLAIN, 30));

    h1 = new JButton("SAVE");
    h1.setFont(new Font("", Font.PLAIN, 30));
    h1.setBounds(950, 850, 200, 70);

    h1.addActionListener(this);
z.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Gokul\\Desktop\\newad.jpg")));
    z.add(h1);


    z.add(l11);
    z.add(l12);
    z.add(l13);
    z.add(l14);
    z.add(l15);

    z.add(t11);
    z.add(t12);
    z.add(t13);
    z.add(t14);
    z.add(t15);

    z.add(t1);
    z.add(b1);


    z.setLayout(null);
    z.setVisible(true);
    z.setExtendedState(JFrame.MAXIMIZED_BOTH);
}
class j {
    public void paint(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage("newad.jpg");
        g.drawImage(i, 1980, 1080, (ImageObserver) this);
    }
}
    public void  actionPerformed(ActionEvent e)
    {
        Connection con;
        Statement st1, st2,st11,st12;
        ResultSet rs;
if(e.getSource()==h1)
{
    String i1, i2,i3, i4, i5;
    i1 = t11.getText();
    i2 = t12.getText();
    i3=t13.getText();
    i4 = t14.getText();
    i5 = t15.getText();
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/id ", "root", "root");
        String query1="insert into admin values('"+i1+"','"+i2+"','"+i3+"','"+i4+"','"+i5+"');";
        st11 = con.createStatement();
        int a=st11.executeUpdate(query1);

    }catch (Exception ex){
        System.out.println(ex);
    }
}
    }

}
