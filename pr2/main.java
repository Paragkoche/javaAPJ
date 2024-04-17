import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main extends JApplet implements ActionListener {
    JButton b1, b2;
    JTextField t1, t2;
    JLabel l1, l2, l3, l4, msg;
    Container cp;
    JRadioButton r1, r2, r3;
    JCheckBox c1, c2, c3;
    String str, str1, str2;
    ButtonGroup bgb, bgb2;
    JPanel p1, p2, p3, p4, p5, p6;

    public void init() {
        cp = getContentPane();
        cp.setLayout(new GridLayout(7, 1));
        p1 = new JPanel();
        FlowLayout s = new FlowLayout(FlowLayout.CENTER, 10, 10);
        p1.setLayout(s);
        p2 = new JPanel();
        p2.setLayout(s);
        p3 = new JPanel();
        p3.setLayout(s);
        p4 = new JPanel();
        p4.setLayout(s);
        p5 = new JPanel();
        p5.setLayout(s);
        p6 = new JPanel();
        p6.setLayout(s);
        cp.add(p1);
        cp.add(p2);
        cp.add(p3);
        cp.add(p4);
        cp.add(p5);
        cp.add(p6);
        l1 = new JLabel("Enter your Name");
        t1 = new JTextField(20);
        l2 = new JLabel("Enter your Age");
        t2 = new JTextField(20);
        bgb = new ButtonGroup();
        l3 = new JLabel("Enter your City");
        r1 = new JRadioButton("Madurai");
        r2 = new JRadioButton("Chennai");
        r3 = new JRadioButton("Trichy");
        bgb.add(r1);
        bgb.add(r2);
        bgb.add(r3);
        l4 = new JLabel("Select your software");
        c1 = new JCheckBox("C");
        c2 = new JCheckBox("C++");
        c3 = new JCheckBox("Java");
        bgb2 = new ButtonGroup();
        bgb2.add(c1);
        bgb2.add(c2);
        bgb2.add(c3);

        b1 = new JButton("OK");
        b2 = new JButton("CANCEL");
        b1.addActionListener(this);
        b2.addActionListener(this);
        r1.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);
        c1.addActionListener(this);
        c2.addActionListener(this);
        c3.addActionListener(this);
        msg = new JLabel("");
        p6.add(msg);
        p1.add(l1);
        p1.add(t1);
        p2.add(l2);
        p2.add(t2);
        p3.add(r1);
        p3.add(r2);
        p3.add(r3);
        p4.add(l4);
        p4.add(c1);
        p4.add(c2);
        p4.add(c3);
        p5.add(b1);
        p5.add(b2);
        msg = new JLabel("");
        p6.add(msg);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            if (r1.isSelected()) {
                str1 = r1.getText();
            } else if (r2.isSelected()) {
                str1 = r2.getText();
            } else if (r3.isSelected()) {
                str1 = r3.getText();
            }
            str = " from the city: " + str1;
            if (c1.isSelected()) {
                str2 = c1.getText();
            }
            if (c2.isSelected()) {
                str2 = c2.getText();
            }
            if (c3.isSelected()) {
                str2 = c3.getText();
            }
            str += " and You have Selected :" + str2;
            msg.setText("Welcome!! " + t1.getText() + " (" + t2.getText() + ") " + str);
        }
        if (ae.getSource() == b2) {
            t1.setText("");
            t2.setText("");
            c1.setSelected(false);
            c2.setSelected(false);
            c3.setSelected(false);
            r1.setSelected(false);
            r2.setSelected(false);
            r3.setSelected(false);
            msg.setText("Your Registration is Cancelled");
        }
    }
}
