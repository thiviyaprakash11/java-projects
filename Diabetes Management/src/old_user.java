

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class old_user extends Component implements ActionListener {
    JProgressBar bar =new JProgressBar();
    JButton h1,h2;

    JTable t1,t2;
    String query3;
    Statement st;
    int row1=0;
    DefaultTableModel dtm;
    JTextField t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21;
    JLabel l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21;
    old_user(String b)
    {
        bar.setValue(0);
        bar.setBounds(0,0,1950,40);

        bar.setForeground(Color.green);
        bar.setBackground(Color.cyan);

        bar.setStringPainted(true);

        JLabel t1=new JLabel("DIABETES STATUS MANAGER");
        t1.setBounds(400,50,1000,100);
        t1.setFont(new Font("",Font.BOLD,40));

        JFrame s=new JFrame("OLD USERF");
        s.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setSize(1400,1000);
        s.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Gokul\\Desktop\\user.jpg")));

        s.setLayout(null);
        s.setVisible(true);

        h1=new JButton("SAVE");
        h1.setFont(new Font("",Font.PLAIN,30));
        h1.setBounds(950,950,200,70);
        h2=new JButton("PRINT");
        h2.setFont(new Font("",Font.PLAIN,30));
        h2.setBounds(1600,800,200,70);
        t11=new JTextField("a");
        t11.setBounds(950,150,200,70);
        t12=new JTextField("b");
        t12.setBounds(950,250,200,70);
        t13=new JTextField();
        t13.setBounds(950,350,200,70);
        t14=new JTextField();
        t14.setBounds(950,450,200,70);
        t15=new JTextField();
        t15.setBounds(950,550,200,70);
        t16=new JTextField();
        t16.setBounds(950,650,200,70);
        t17=new JTextField();
        t17.setBounds(950,750,200,70);
        t18=new JTextField();
        t18.setBounds(950,850,200,70);
        t18.setFont(new Font("", Font.PLAIN, 20));
        t11.setFont(new Font("", Font.PLAIN, 20));
        t12.setFont(new Font("", Font.PLAIN, 20));
        t13.setFont(new Font("", Font.PLAIN, 20));
        t14.setFont(new Font("", Font.PLAIN, 20));
        t15.setFont(new Font("", Font.PLAIN, 20));
        t16.setFont(new Font("", Font.PLAIN, 20));
        t17.setFont(new Font("", Font.PLAIN, 20));


        l11=new JLabel("NAME");
        l11.setBounds(750,150,100,70);
        l11.setFont(new Font("",Font.PLAIN,30));
        l12=new JLabel("AGE");
        l12.setBounds(750,250,100,70);
        l12.setFont(new Font("",Font.PLAIN,30));
        l13=new JLabel("ID");
        l13.setBounds(750,350,100,70);
        l13.setFont(new Font("",Font.PLAIN,30));
        l14=new JLabel("GENDER ");
        l14.setBounds(750,450,200,70);
        l14.setFont(new Font("",Font.PLAIN,30));
        l15=new JLabel("D O B");
        l15.setBounds(750,550,100,70);
        l15.setFont(new Font("",Font.PLAIN,30));
        l16=new JLabel(" SUGAR LEVEL");
        l16.setBounds(440,650,300,70);
        l16.setFont(new Font("",Font.PLAIN,30));
        l19=new JLabel("FASTING");
        l19.setBounds(740,650,300,70);
        l19.setFont(new Font("",Font.PLAIN,30));
        l17=new JLabel("AFTER FASTING");
        l17.setBounds(640,750,300,70);
        l17.setFont(new Font("",Font.PLAIN,30));
        l18=new JLabel("DATE");
        l18.setBounds(750,850,100,70);
        l18.setFont(new Font("",Font.PLAIN,30));
        h1.addActionListener(this);
        h2.addActionListener(this);

        s.add(l11);
        s.add(l12);
        s.add(l13);
        s.add(l14);
        s.add(l15);
        s.add(l16);
        s.add(l17);
        s.add(bar);
        s.add(h2);

        s.add(t11);
        s.add(t12);
        s.add(t13);
        s.add(t14);
        s.add(t15);
        s.add(t16);
        s.add(t17);
        s.add(l19);

s.add(t18);
s.add(l18);
        s.add(t1);
        s.add(h1);


        s.setVisible(true);
        s.setLayout(null);
        t13.setEditable(false);


        DefaultTableModel dtm1 = new DefaultTableModel();
        JTable t2 = new JTable(dtm1);

        t2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 1), BorderFactory.createEmptyBorder(0, 3, 0, 3)));

        t2.setBounds(1200, 200, 800, 500);

        s.add(t2);

        dtm1.addColumn("");
        dtm1.addColumn("");
        dtm1.addColumn("");
        dtm1.addColumn("");
        dtm1.insertRow(row1, new String[]{"ID", "Before","After", "Date"});
        Connection con1;

        ResultSet rs1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/id ", "root", "root");
             query3 = "select * from sugar where id='" + b + "';";
            st = con1.createStatement();
            rs1 = st.executeQuery(query3);
            while (rs1.next()) {
                String id1 = rs1.getString(1);
                String sln1 = rs1.getString(2);
                String sln2 = rs1.getString(3);
                String date1 = rs1.getString(4);
                row1++;
                dtm1.insertRow(row1, new String[]{id1, sln1,sln2, date1});
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        Connection con;
        Statement st1,st11;
        ResultSet rs;
        String b1,b2,b3,b4,b5 = null;
        int as= Integer.parseInt(b);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/id", "root", "root");
            st1=con.createStatement();
            String query="select * from details where id='"+as+"'";
            rs=st1.executeQuery(query);

            while( rs.next()) {
                b1 = rs.getString(1);
                b2 = rs.getString(2);
                b3 = rs.getString(3);
                b4 = rs.getString(4);
                b5 = rs.getString(5);
                System.out.println(b1);
                System.out.println(b2);
                System.out.println(b3);
                System.out.println(b4);
                System.out.println(b5);



                t11.setText(b1);
                t12.setText(b2);
                t13.setText(b3);
                t14.setText(b4);
                t15.setText(b5);


            }

        } catch (Exception ex) {
            System.out.println("hhhh");
        }

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
    public void actionPerformed (ActionEvent e) {
        Connection con1;
        Statement st12;
        ResultSet rs1;
        if(e.getSource()==h1) {


            fill();
            try {
                String y1,y4, y2, y3;
                y1 = t13.getText();
                y2 = t16.getText();
                y3=t17.getText();
                y4=t18.getText();
                System.out.println(y1 + y2 + y3+y4);

                Class.forName("com.mysql.cj.jdbc.Driver");
                con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/id", "root", "root");


                st12 = con1.createStatement();
                System.out.println("before");
                String query1 = "insert into sugar values('"+y1+"','"+y2+"','"+y3+"','"+y4+"');";
                int a=st12.executeUpdate(query1);
                System.out.println("after");
                System.out.println(a);

            }
            catch (Exception w) {
                System.out.println("aaaa");
                System.out.println(w);
            }
        }
        if(e.getSource()==h2) {
            String path="";
            JFileChooser j=new JFileChooser();
            j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int x=j.showSaveDialog(this);
            if(x==JFileChooser.APPROVE_OPTION)
            {
                path=j.getSelectedFile().getPath();
            }

            try
            {

            }
            catch (Exception eg)
            {
                System.out.println(eg);
                JOptionPane.showMessageDialog(null,eg);
            }

        }


    }
    }

