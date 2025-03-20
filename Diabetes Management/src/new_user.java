
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class new_user implements ActionListener {
    JButton h1;
    JProgressBar bar =new JProgressBar();
    JFrame s;
    JTextField t11, t12, t13, t14, t15, t16, t17, t18;
    JLabel l11, l12, l13, l14, l15, l16, l17, l18;
    JLabel t1;


    private int as;
    private int a;

    new_user() {

        bar.setValue(0);
        bar.setBounds(0,0,1950,40);

        bar.setForeground(Color.green);
        bar.setBackground(Color.cyan);

        bar.setStringPainted(true);
        t1 = new JLabel("DIABETES STATUS MANAGER");
        t1.setBounds(690, 50, 1000, 100);
        t1.setFont(new Font("", Font.BOLD, 40));
        s = new JFrame("NEW USERF");
        s.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        s.setLayout(null);
        s.setVisible(true);

        h1 = new JButton("SAVE");

        h1.setFont(new Font("", Font.PLAIN, 30));
        h1.setBounds(950, 850, 200, 70);

        h1.addActionListener(this);

        s.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Gokul\\Desktop\\imw.jpg")));

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

        t11.setFont(new Font("", Font.PLAIN, 20));
        t12.setFont(new Font("", Font.PLAIN, 20));
        t13.setFont(new Font("", Font.PLAIN, 20));
        t14.setFont(new Font("", Font.PLAIN, 20));
        t15.setFont(new Font("", Font.PLAIN, 20));
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


        s.add(l11);
        s.add(l12);
        s.add(l13);
        s.add(l14);
        s.add(l15);

        s.add(t11);
        s.add(t12);
        s.add(t13);
        s.add(t14);
        s.add(t15);

        s.add(t1);
        s.add(bar);

        s.add(h1);

        //s.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Gokul\\Desktop\\images (2).jpg")));

        s.setVisible(true);
        s.setLayout(null);
        //t11.setEditable(false);
        //t12.setEditable(false);
        t13.setEditable(false);
        //t14.setEditable(false);
        //t15.setEditable(false);
        //t16.setEditable(false);
        //t17.setEditable(false);
        //t18.setEditable(false);


        Connection con;
        Statement st1, st2,st11,st12;
        ResultSet rs;
        String b = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/id", "root", "root");
            st1=con.createStatement();
            String query="select * from id";
            rs=st1.executeQuery(query);
            while( rs.next()) {
                b = rs.getNString(1);
                System.out.println(b);
            }

        } catch (Exception ex) {
            System.out.println("hhhh");
        }
        int as= Integer.parseInt(b);
        as++;
        t13.setText(String.valueOf(as));
    }
public  void fill()
{
    int counter=0;
    while (counter<=100)
    {
        bar.setValue(counter);
        try {
            Thread.sleep(10);
        }catch (InterruptedException jj)
        {}
        counter+=1;
    }
    bar.setString("RECORD SAVED");
}
    public void actionPerformed (ActionEvent e){
        Connection con;
        Statement st1, st2,st11,st12;
        ResultSet rs;
        if (e.getSource() == h1) {
            String i1, i2,i3, i4, i5;
            i1 = t11.getText();
            i2 = t12.getText();
            i3=t13.getText();
            i4 = t14.getText();
            i5 = t15.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/id ", "root", "root");
                String query1="insert into details values('"+i1+"','"+i2+"','"+i3+"','"+i4+"','"+i5+"');";
                st11 = con.createStatement();
                int a=st11.executeUpdate(query1);
                System.out.println(as);
                String q2="update  id set id='"+i3+ "';";
                st12=con.createStatement();
                int c=st12.executeUpdate(q2);
                System.out.println(c);
            }catch (Exception ex){
                System.out.println(ex);
            }

            System.out.println(i1 + i2 + i3+i4 + i5 );
            Thread t1=new Thread(){
               public void run(){
                   fill();
               }
            };
           t1.start();
        }
    }


    }



