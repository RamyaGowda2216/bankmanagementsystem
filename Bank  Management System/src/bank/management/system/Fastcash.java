
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
        
        

public class Fastcash extends JFrame implements ActionListener {
    
    JButton deposit, withdrawl, ministatement, pin_change, fastcash, balanceenquiry, exit;
    String pinnumber;
     Fastcash(String pinnumber) {
         this.pinnumber = pinnumber;
         
         setLayout(null);
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0, 0, 900, 810);
         add(image);
        
         JLabel text = new JLabel("Please select Withdrawal Amount:");
         text.setFont(new Font("System", Font.BOLD, 16));
         text.setForeground(Color.WHITE);
         text.setBounds(210, 250, 700, 35);
         image.add(text);
         
         deposit = new JButton("Rs 100");
         deposit.setBounds(170, 315, 150, 30);
         deposit.addActionListener(this);
         image.add(deposit);
         
         withdrawl = new JButton("Rs 500");
         withdrawl.setBounds(355, 315, 150, 30);
         withdrawl.addActionListener(this);
         image.add(withdrawl);
         
         fastcash = new JButton("Rs 1000");
         fastcash.setBounds(170, 350, 150, 30);
         fastcash.addActionListener(this);
         image.add(fastcash);
         
         ministatement = new JButton("Rs 2000");
         ministatement.setBounds(355, 350, 150, 30);
         ministatement.addActionListener(this);
         image.add(ministatement);
         
         pin_change = new JButton("Rs 5000");
         pin_change.setBounds(170, 385, 150, 30);
         pin_change.addActionListener(this);
         image.add(pin_change);
         
         balanceenquiry = new JButton("Rs 10000");
         balanceenquiry.setBounds(355, 385, 150, 30);
         balanceenquiry.addActionListener(this);
         image.add(balanceenquiry);
         
         exit = new JButton("BACK");
         exit.setBounds(355, 420, 150, 30);
         exit.addActionListener(this);
         image.add(exit);
         
         setSize(900, 900);
         setLocation(300, 0);
         setUndecorated(true);
         setVisible(true);
        
         
         
     }
     
     public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == exit) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
         } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                       balance+= Integer.parseInt(rs.getString("amount"));
                    } else {
                         balance-= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficiant Balance");
                    return;
                }
                
               Date date = new Date();
               String query = "insert into bank values('"+pinnumber+"', '"+date+"', '"+withdrawl+"', '"+amount+"')";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Rs "+ amount + "Debited succusfully");
               
               setVisible(false);
               new Transaction(pinnumber).setVisible(true);
            } catch(Exception e) {
                System.out.println(e);
            }
         }
     }
    
    public static void main(String args[]) {
        
        new Fastcash("");
    }
}
