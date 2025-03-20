import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TextFieldExample implements ActionListener{
    JTextField tf1,tf2,tf3;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13;
    TextFieldExample(){ JFrame f=new JFrame("BASE CONVERTER ");
        JLabel l1,l2,l3,l4;
        l1=new JLabel("INPUT");
        l1.setFont(new Font("",Font.PLAIN,30));
        l1.setBounds(625,50,100,30);
        l2=new JLabel("RESULT");
        l2.setBounds(625,125,200,30);
        l2.setFont(new Font("",Font.PLAIN,30));
        l3=new JLabel("LOGICAL GATES PAGE");
        l3.setBounds(900,900,400,30);
        l3.setFont(new Font("",Font.PLAIN,30));
        l4=new JLabel("BASE CONVERTER PAGE");
        l4.setFont(new Font("",Font.PLAIN,30));
        l4.setBounds(50,50,400,30);
        tf1=new JTextField();
        tf1.setBounds(750,50,150,40);
        tf2=new JTextField();
        tf2.setBounds(750,120,150,40);
        tf2.setEditable(false);
        b1=new JButton("Binary to Decimal");
        b1.setBounds(500,200,200,100);
        b2=new JButton("Binary to Octal");
        b2.setBounds(750,200,200,100);
        b3=new JButton("Binary to Hexa");
        b3.setBounds(1000,200,200,100);
        b4=new JButton("Decimal to Octal");
        b4.setBounds(500,350,200,100);
        b5=new JButton("Decimal to Hexa");
        b5.setBounds(750,350,200,100);
        b6=new JButton("Decimal to Binary");
        b6.setBounds(1000,350,200,100);
        b7=new JButton("Hexa to Binary");
        b7.setBounds(500,500,200,100);
        b8=new JButton("Hexa to octal");
        b8.setBounds(750,500,200,100);
        b9=new JButton("Hexa to Decimal");
        b9.setBounds(1000,500,200,100);
    b10=new JButton("Octal to Binary");
    b10.setBounds(500,650,200,100);
    b11=new JButton("Octal to Hexa");
    b11.setBounds(750,650,200,100);
    b12=new JButton("Octal to Decimal");
    b12.setBounds(1000,650,200,100);
    b13=new JButton("NEXT");
    b13.setBounds(1000,800,150,100);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    b7.addActionListener(this);
    b8.addActionListener(this);
    b9.addActionListener(this);
    b10.addActionListener(this);
    b11.addActionListener(this);
    b12.addActionListener(this);
    b13.addActionListener(this);
    f.add(tf1); f.add(tf2);
    f.add(b1); f.add(b2);
    f.add(b3); f.add(b4);
    f.add(b5); f.add(b6);
    f.add(b7); f.add(b8);
    f.add(b9); f.add(b10);
    f.add(b11); f.add(b12);
    f.add(l1);
    f.add(l2);
    f.add(l4);
    f.setSize(1400,1000);
    f.setLayout(null);
    f.setVisible(true); }
    public void actionPerformed(ActionEvent e) {
        int a = 0, c = 0;
        String s1 = "";
        s1 = tf1.getText();
        if (e.getSource() != b12||e.getSource() != b10||e.getSource() != b11) {
            a = Integer.parseInt(s1);
            c = 0;
        }
        if (e.getSource() == b1) {
            int n = 0;
            while (true) {
                if (a == 0) {
                    break;
                } else {
                    int temp = a % 10;
                    c += temp * Math.pow(2, n);
                    a = a / 10;
                    n++;
                }
            }
            String result = String.valueOf(c);
            tf2.setText(result);
        }
        if (e.getSource() == b2) {
            int num;
            num = Integer.parseInt(s1, 2);
            String octal = Integer.toOctalString(num);
            String result = String.valueOf(octal);
            tf2.setText(result);
        }
        if (e.getSource() == b3) {
            int number;
            number = Integer.parseInt(s1, 2);
            String ci = Integer.toHexString(number);
            String result = String.valueOf(ci);
            tf2.setText(result);
        }
        if (e.getSource() == b4) {
            int rem;
            String octal = "";
            char octalchars[] = {'0', '1', '2', '3', '4', '5', '6', '7'};
            while (a > 0) {
                rem = a % 8;
                octal = octalchars[rem] + octal;
                a = a / 8;
            } String result = String.valueOf(octal);
            tf2.setText(result);
        } if (e.getSource() == b5) {
            int rem;
            String hex = "";
            char hexchars[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            while (a > 0) {
                rem = a % 16;
                hex = hexchars[rem] + hex;
                a = a / 16;
            }
            String result = String.valueOf(hex);
            tf2.setText(result);
        }
        if (e.getSource() == b6) {

            String ci = Integer.toBinaryString(a);
            String result = String.valueOf(ci);
            tf2.setText(result);
        } if (e.getSource() == b7) {
            int num;
            num = Integer.parseInt(s1, 16);
            String binary = Integer.toBinaryString(num);
            String result = String.valueOf(binary);
            tf2.setText(result);
        }
        if (e.getSource() == b8) {
            int c2 = Integer.parseInt(s1, 16);
            String octal = Integer.toOctalString(c2);
            String result = String.valueOf(octal);
            tf2.setText(result);
        }
        if (e.getSource() == b9) {
            int decimal = Integer.parseInt(s1, 16);

            String result = String.valueOf(decimal);
            tf2.setText(result);
        } if (e.getSource() == b10) {
            int num;
            num = Integer.parseInt(s1, 8);
            String binary = Integer.toBinaryString(num);
            String result = String.valueOf(binary);
            tf2.setText(result);
        }
        if (e.getSource() == b11) {
            String hexnum;
            int decnum;
            decnum = Integer.parseInt(s1, 8);
            hexnum = Integer.toHexString(decnum).toUpperCase();
            String result = String.valueOf(hexnum);
            tf2.setText(result);
        }
        if (e.getSource() == b12) {
            int decimal = 0; //Declaring variable to use in power23
            int n = 0;
            {
                if (a== 0) {

                } else {
                    int temp = a % 10;
                    decimal += temp * Math.pow(8, n);
                    a = a / 10;
                    n++;
                }
            }
            String result = String.valueOf(decimal);
            tf2.setText(result);
        }
    }
    public static void main (String args[]){
        new TextFieldExample(); } }