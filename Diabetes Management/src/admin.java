import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class admin implements ActionListener {
    JButton h1;
    JButton b3, b4, b1;
    JLabel l1, l2;
    JFrame z;
    int row = 0, row1 = 0;
    JTextField te1, te2;

    admin() {
        te1 = new JTextField();
        te2 = new JTextField();
        te1.setBounds(1300, 100, 200, 50);
        //te2.setBounds(175, 700, 200, 50);
        JFrame z = new JFrame("admin");
        z.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Gokul\\Desktop\\ad.jpg")));
        z.add(te1);
        //z.add(te2);
        b3 = new JButton("USER ID");
        b3.setFont(new Font("", Font.PLAIN, 20));
        b3.setBounds(1550, 100, 200, 50);
        z.add(b3);
        b3.addActionListener(this);


        l1 = new JLabel("ENTER USER ID");
        l1.setBounds(1125, 95, 300, 70);
        l1.setFont(new Font("", Font.PLAIN, 20));
        z.add(l1);

        b4 = new JButton("Delete all");
        b4.setFont(new Font("", Font.PLAIN, 20));
        b4.setBounds(225, 205, 100, 50);
        b4.addActionListener(this);
        b1 = new JButton("Delete ");
        b1.setFont(new Font("", Font.PLAIN, 20));
        b1.setBounds(350, 205, 100, 50);
        b1.addActionListener(this);

        l2 = new JLabel("PASSWORD");
        l2.setBounds(60, 135, 300, 70);
        l2.setFont(new Font("", Font.PLAIN, 20));
      b3.addActionListener(new ActionListener() {
          public  void actionPerformed(ActionEvent e) {
                row1=0;
              String q = te1.getText();
              DefaultTableModel dtm1 = new DefaultTableModel();
              JTable t2 = new JTable(dtm1);

              t2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 1), BorderFactory.createEmptyBorder(0, 3, 0, 3)));

              t2.setBounds(1000, 200, 800, 500);

              z.add(t2);

              dtm1.addColumn("");
              dtm1.addColumn("");
              dtm1.addColumn("");
              dtm1.insertRow(row1, new String[]{"ID", "Sugar Level", "Date"});
              Connection con1;
              Statement st;
              ResultSet rs1;
              try {
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/id ", "root", "root");
                  String query3 = "select * from sugar where id='" + q + "';";
                  st = con1.createStatement();
                  rs1 = st.executeQuery(query3);
                  while (rs1.next()) {
                      String id1 = rs1.getString(1);
                      String sln1 = rs1.getString(2);
                      String date1 = rs1.getString(3);
                      row1++;
                      dtm1.insertRow(row1, new String[]{id1, sln1, date1});
                  }
              } catch (Exception ex) {
                  System.out.println(ex);
              }

          }
      });

        DefaultTableModel dtm = new DefaultTableModel();
        JTable t1 = new JTable(dtm);
        t1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 1), BorderFactory.createEmptyBorder(0, 3, 0, 3)));
        t1.setBounds(100, 200, 800, 500);
        dtm.addColumn("");
        dtm.addColumn("");
        dtm.addColumn("");
        dtm.addColumn("");
        dtm.addColumn("");
        dtm.insertRow(row, new String[]{"Name", "Age", "Id", "Gender", "D.O.B"});
        Connection con;
        Statement st1, st2, st11, st12;
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/id ", "root", "root");
            String query1 = "select * from details;";
            st11 = con.createStatement();
            rs = st11.executeQuery(query1);
            while (rs.next()) {
                String sno = rs.getString(1);
                String age = rs.getString(2);
                String id = rs.getString(3);
                String gender = rs.getString(4);
                String date = rs.getString(5);
                row++;
                dtm.insertRow(row, new String[]{sno, age, id, gender, date});
            }
        } catch (Exception ex) {

        }
        z.add(t1);


        z.setLayout(null);
        z.setVisible(true);
        z.setExtendedState(JFrame.MAXIMIZED_BOTH);
        h1 = new JButton("NEW ADMIN");

        h1.setFont(new Font("", Font.PLAIN, 20));
        h1.setBounds(1650, 850, 200, 70);

        h1.addActionListener(this);

        z.add(h1);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == h1) {
            newadmin ad = new newadmin();
        }
        if (e.getSource() == b3) {
        }

    }
}




