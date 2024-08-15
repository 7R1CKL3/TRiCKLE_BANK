/**
 * 
 *  @author (Himal Sharma)
 * @version (5.1.0)
 */


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;


public class BankGUI implements ActionListener
{
    private JFrame frame;
    private JPanel panel,cpanel,dpanel;
    private JLabel l1;
    private JButton dc,cc;
    
    //instances for Debit Card
    private JLabel debit;
    private JLabel card__id,client__name,issuer__bank,bank__account,balance__amount,pin__number,w_am,d_o_w;
    private JTextField c_i,c_n,i_b,b_a,b_am,d_w_am;
    
    private JButton back,d_disp,d_add_deb,d_clear,withdrw;
    
    private JComboBox d_d_o_w,m_d_o_w,y_d_o_w;
    
    private JPasswordField pin_num;
    
    
    
    
    //instances for Credit Card
    
    private JLabel credit;
    
    private JLabel c_card__id,c_client__name,c_issuer__bank,c_bank__account,c_balance__amount,cvc__number,int_rate
    ,c_grace_p,c_credit_l,c_expiration_d;
    
    private JButton add_c_c,cancel_cc,c_clear,s_cr_l,c_disp,back2;
    
    private JComboBox c_exp_d,c_exp_m,c_exp_y;
    
    private JTextField c_c_i,c_c_n,c_i_b,c_b_a,c_b_am,c_int_r,c_gr_p,c_cr_l;
    
    private JPasswordField cvc_num;
    
    ArrayList <BankCard> Bank_List = new ArrayList();
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == cc) {
            panel.setVisible(false);
            cpanel.setVisible(true);
            frame.setTitle("Credit Card");
        }
        
        if (e.getSource() == dc){
            panel.setVisible(false);
            dpanel.setVisible(true);
            frame.setTitle("Debit Card");
        }
        
        if (e.getSource() == back) {
            dpanel.setVisible(false);
            panel.setVisible(true);
            frame.setTitle("TRiCKLE BANK");
        }
        
        if (e.getSource() == back2) {
            cpanel.setVisible(false);
            panel.setVisible(true);
            frame.setTitle("TRiCKLE BANK");
        }
        
        if (e.getSource() == d_clear) {
            c_i.setText("");
            c_n.setText("");
            i_b.setText("");
            b_a.setText("");
            b_am.setText("");
            pin_num.setText("");
            d_w_am.setText("");
            d_d_o_w.setSelectedIndex(0);
            m_d_o_w.setSelectedIndex(0);
            y_d_o_w.setSelectedIndex(0);
        }
        
        if (e.getSource() == c_clear) {
            c_c_i.setText("");
            c_c_n.setText("");
            c_i_b.setText("");
            c_b_a.setText("");
            c_b_am.setText("");
            cvc_num.setText("");
            c_int_r.setText("");
            c_gr_p.setText("");
            c_cr_l.setText("");
            c_exp_d.setSelectedIndex(0);
            c_exp_m.setSelectedIndex(0);
            c_exp_y.setSelectedIndex(0);
        }
        
        if (e.getSource() == d_add_deb) {
            if (c_i.getText().isEmpty() || c_n.getText().isEmpty() || i_b.getText().isEmpty() ||
            b_a.getText().isEmpty() || b_am.getText().isEmpty() || pin_num.getText().isEmpty()) {
                JOptionPane.showMessageDialog(dpanel,"Please fill all the required credintials");
            }  
            else{
                try{
                    int card_id = Integer.valueOf(c_i.getText());
                    double balance_amount  = Double.valueOf(b_am.getText());
                    int pin_number = Integer.valueOf(pin_num.getText());
                    
                    String bank_account = String.valueOf(b_a.getText());
                    String issuer_bank = String.valueOf(i_b.getText());
                    String client_name = String.valueOf(c_n.getText()); 
                    
                    boolean id = true;
                    for (BankCard bank_obj: Bank_List) {
                        if (bank_obj instanceof DebitCard) {
                            DebitCard debitcard_obj = (DebitCard) bank_obj;
                            if (debitcard_obj.getCard_Id() == card_id) {
                                id = false;
                            }
                        }
                    }
                    if (id == true) {
                        DebitCard debit_obj = new DebitCard(balance_amount,card_id,bank_account,issuer_bank,
                        client_name,pin_number);
                        Bank_List.add(debit_obj);
                        JOptionPane.showMessageDialog(null,"Debit Card has been added successfully\nCard Id: "+debit_obj.getCard_Id()+
                        "\nClient Name: "+debit_obj.getclient_Name()+"\nIssuer Bank: "+debit_obj.getissuer_Bank()+"\nBank Account: "+debit_obj.getbank_Account()+
                        "\nBalance Amount: "+debit_obj.getbalance_Amount());
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"This Card ID already exists\n cannot add the details again");
                    }
                    
                    }
                catch (Exception f) {
                    JOptionPane.showMessageDialog(null,"Please enter correct credintials to add Debit Card");
                }
                
            }
        }
        
        if (e.getSource() == withdrw) {
            if (d_w_am.getText().isEmpty() && c_i.getText().isEmpty() && pin_num.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Card Id, Withdraw Amount and PIN Number can not be empty to withdraw");
            }
            else if (d_w_am.getText().isEmpty() && c_i.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Card Id and Withdraw Amount can not be empty");
            }
            
            else if (d_w_am.getText().isEmpty() && pin_num.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"PIN Number and Withdraw Amount can not be empty");
            }
            
            else if (pin_num.getText().isEmpty() && c_i.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Card ID and PIN Number can not be empty");
            }
            
            else if (d_w_am.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Enter the amount to withdraw");
            }
            
            else if (c_i.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Card Id can not be empty to withdraw");
            }
            
            else if (pin_num.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"PIN Number can not be empty to withdraw");
            }
            else {
                
                try {
                    int card_id = Integer.valueOf(c_i.getText());
                    int withdraw_amount = Integer.valueOf(d_w_am.getText());
                    double balance_amount = Double.valueOf(b_am.getText());
                    int pin_number = Integer.valueOf(pin_num.getText());
                    String bank_account = String.valueOf(b_a.getText());
                     
                    String withdrawal_date = y_d_o_w.getSelectedItem()+" " + m_d_o_w.getSelectedItem()+" " + d_d_o_w.getSelectedItem();
                    
                    boolean cardID = true;
                    for (BankCard bank_obj : Bank_List) {
                        if (bank_obj instanceof DebitCard) {
                            DebitCard display_obj = (DebitCard) bank_obj;
                            cardID = false;
                            if (display_obj.getCard_Id() == card_id && display_obj.getpin_Number() == pin_number) {
                                
                                if (display_obj.getbalance_Amount() >= withdraw_amount) {
                                    display_obj.withdraw(withdraw_amount, withdrawal_date,pin_number);
                                    display_obj.display();   //To display in console
                                    JOptionPane.showMessageDialog(null,"Card Details\nCard ID: "+display_obj.getCard_Id()+
                                    "\nWithdrawn Amount: "+display_obj.getwithdrawal_Amount()+"\nDate Of Withdrawal: "+display_obj.getdate_Of_Withdrawal());
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"Insufficient Balance Amount!!");
                                }
                            }
                            
                        }
                    }
                    if (cardID == true){
                        JOptionPane.showMessageDialog(null,"The card does not exists","Invalid Credential",
                        JOptionPane.WARNING_MESSAGE);
                    }
                    
                }
                catch (NumberFormatException g) {
                    JOptionPane.showMessageDialog(null,"Withdraw Amount can only be Number");
                }
            }
        }
        
        if (e.getSource() == d_disp) {
            String bank_account = String.valueOf(b_a.getText());
            String issuer_bank = String.valueOf(i_b.getText());
            String client_name = String.valueOf(c_n.getText()); 
            String withdrawal_date = y_d_o_w.getSelectedItem()+" " + m_d_o_w.getSelectedItem()+" " + d_d_o_w.getSelectedItem();
            boolean id = true;
            for (BankCard display : Bank_List) {
                DebitCard display_obj = (DebitCard) display;
                if (display instanceof DebitCard && display_obj.getCard_Id() == Integer.valueOf(c_i.getText())) {
                    display_obj.display();  //TO display in console
                    id = false;
                    if (display_obj.gethas_Withdrawn()==true) {      
                        JOptionPane.showMessageDialog(null,"Debit Card Details:\nCard Id: "+display_obj.getCard_Id()+
                        "\nClient Name: "+display_obj.getclient_Name()+"\nIssuer Bank: "+display_obj.getissuer_Bank()+"\nBank Account: "+display_obj.getbank_Account()+
                        "\nBalance Amount: "+display_obj.getwithdrawal_Amount()+"\nPIN Number: "+display_obj.getpin_Number());
                    }
                }
                
            }
            if (id == true) {
                JOptionPane.showMessageDialog(null,"The card ID has not been added \n cannot diplay any data");
            }
        }
        
        if (e.getSource() == add_c_c) {
            
            if (c_i_b.getText().isEmpty() || c_c_n.getText().isEmpty() || c_c_i.getText().isEmpty() ||
            c_b_a.getText().isEmpty() || c_b_am.getText().isEmpty() || cvc_num.getText().isEmpty() ||
            c_int_r.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Please fill all the required credintials");
            }
                
            else {
                try {
                    int credit_card_id = Integer.valueOf(c_c_i.getText());
                    double credit_balance_amount  = Double.valueOf(c_b_am.getText());
                    int cvc_number = Integer.valueOf(cvc_num.getText());
                    int credit_interest_rate = Integer.valueOf(c_int_r.getText());
                           
                    String credit_bank_account = String.valueOf(c_b_a.getText());
                    String credit_issuer_bank = String.valueOf(c_i_b.getText());
                    String credit_client_name = String.valueOf(c_c_n.getText());
                    String credit_expiration_date = String.valueOf(c_expiration_d.getText());
                    
                    
                    boolean id = true;
                    for (BankCard bank_obj : Bank_List) {
                        if (bank_obj instanceof CreditCard) {
                            CreditCard display_obj = (CreditCard) bank_obj;
                            if (display_obj.getCard_Id() == credit_card_id) {
                                id = false;
                            }
                        }
                    }
                    if (id == true) {
                        CreditCard credit_obj = new CreditCard(credit_card_id,credit_client_name,credit_issuer_bank,
                        credit_bank_account,credit_balance_amount,cvc_number,credit_interest_rate,credit_expiration_date);
                        Bank_List.add(credit_obj);
                        String expiration_date = c_exp_y.getSelectedItem()+" " + c_exp_m.getSelectedItem()+" " + c_exp_d.getSelectedItem();

                        JOptionPane.showMessageDialog(null,"Credit Card has been added successfully\nCard Id: "+
                        credit_obj.getCard_Id()+"\nClient Name: "+credit_obj.getclient_Name()+"\nIssuer Bank: "+credit_obj.getissuer_Bank()+
                        "\nBank Account: "+credit_obj.getbank_Account()+"\nBalance Amount: "+credit_obj.getbalance_Amount()+
                        "\nCVC Number: "+credit_obj.getcvc_Number());
                    }
                            
                    else {
                        JOptionPane.showMessageDialog(null,"This Card already exists \n can not add it again!!");
                    }
                }
                catch (Exception l) {
                    JOptionPane.showMessageDialog(null,"Please enter valid card details!",
                        "Invalid Credential",JOptionPane.WARNING_MESSAGE);
                }
            } 
        }
        
        if (e.getSource() == s_cr_l) {
                    
            if (c_cr_l.getText().isEmpty() && c_gr_p.getText().isEmpty() && c_c_i.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Card ID, Grace Period and Credit Limit can not be empty");
            }
            
            else if (c_cr_l.getText().isEmpty() && c_c_i.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Card ID and Credit Limit can not be empty");
            }
            
            else if (c_gr_p.getText().isEmpty() && c_c_i.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Card ID and Grace Period can not be empty");
            }
            
            else if (c_gr_p.getText().isEmpty() && c_cr_l.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Credit Limit and Grace Period can not be empty");
            }
                    
            else if (c_cr_l.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Credit Limit can not be empty");
            }
                    
            else if (c_gr_p.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Grace Period can not be empty");
            }
            
            else if (c_c_i.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Card ID can not be empty");
            }
            else {
                try {
                    int grace_period = Integer.valueOf(c_gr_p.getText());
                    double credit_limit = Double.valueOf(c_cr_l.getText());
                    int card_id = Integer.valueOf(c_c_i.getText());
                    int cvc_number = Integer.valueOf(cvc_num.getText());
                    int credit_card_id = Integer.valueOf(c_c_i.getText());
                    
                    boolean cardID = true;
                    
                    for (BankCard bank_obj : Bank_List) {
                        if (bank_obj instanceof CreditCard) {
                            
                            CreditCard credit_obj = (CreditCard) bank_obj;
                            
                            if (credit_obj.getCard_Id() == card_id ) {
                                if (credit_obj.getis_Granted() == false) {
                                    cardID = false; 
                                    
                                    if (credit_limit <= 2.5* credit_obj.getbalance_Amount()) {
                                        credit_obj.setcredit_Limit(credit_limit, grace_period);
                                        credit_obj.display();           //To display in console
                                        JOptionPane.showMessageDialog(null,"Credit Limit Details\nCard ID: "+credit_obj.getCard_Id()+
                                        "\nCredit Limit: "+credit_obj.getcredit_Limit()+"\nGrace Period: "+credit_obj.getgrace_Period());
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null,"Insufficient Balance to Set Credit",
                                        "Invalid Credential",JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                                else {}
                            }
                            else {
                                
                            }
                    }
                    
                }
                if (cardID == true) {
                        JOptionPane.showMessageDialog(null,"This card already exists!");
                    }
            }
                catch (NumberFormatException o) {
                    JOptionPane.showMessageDialog(null,"Please enter valid data!",
                    "Invalid Data",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        
        if (e.getSource() == cancel_cc) {
            if(c_c_i.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Card ID is can not be Empty!!");
            }
            else {
                try {
                    int card_id = Integer.valueOf(c_c_i.getText());
                    boolean id= false;
                    for (BankCard cancel_credit: Bank_List) {
                        if(cancel_credit instanceof CreditCard && cancel_credit.getCard_Id()== card_id) {
                            id = true;
                            CreditCard credit_limit = (CreditCard) cancel_credit;
                            
                            if (credit_limit.getis_Granted() == true) {
                                credit_limit.cancelCreditCard();
                                JOptionPane.showMessageDialog(null, "The credit card is cancelled");
                                
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "The credit card has already been cancelled");
                            }
                        }
                    }
                    if(id == false) {
                        JOptionPane.showMessageDialog(null, "This card doesn't exist try adding the Card");
                    }
                }
                 catch(NumberFormatException v) {
                     JOptionPane.showMessageDialog(null, "Card ID can only be number");
                }
            }
        }
        
        if (e.getSource() == c_disp) {
            int card_id = Integer.valueOf(c_c_i.getText());
            String bank_account = String.valueOf(c_b_a.getText());
            String issuer_bank = String.valueOf(c_i_b.getText());
            String client_name = String.valueOf(c_c_n.getText()); 
            String expiration_date = y_d_o_w.getSelectedItem()+" " + m_d_o_w.getSelectedItem()+" " + d_d_o_w.getSelectedItem();

            boolean is_granted = false;
            for (BankCard display : Bank_List) {
                if (display instanceof CreditCard) {
                    CreditCard credit_obj = (CreditCard) display;
                    if (credit_obj.getCard_Id() == Integer.valueOf(c_c_i.getText())) {
                        is_granted = true;
                        credit_obj.display();           //To display in console
                        
                        JOptionPane.showMessageDialog(null,"Credit Card Details:\nCard Id: "+credit_obj.getCard_Id()+
                        "\nClient Name: "+credit_obj.getclient_Name()+"\nIssuer Bank: "+credit_obj.getissuer_Bank()+"\nBank Account: "+credit_obj.getbank_Account()+
                        "\nBalance Amount: "+Double.valueOf(c_b_am.getText())+"\nCVC Number: "+
                        credit_obj.getcvc_Number()+"\nInterest Rate: "+credit_obj.getissuer_Bank()+
                        "\nGrace Period: "+credit_obj.getgrace_Period()+
                        "\nCredit Limit: "+credit_obj.getcredit_Limit());
                    }
                }
            }
            if (is_granted == false) {
                JOptionPane.showMessageDialog(null,"The card ID has not been added \n cannot diplay any data");
            }
        }
        
    }
    
    public void GUI(){
        frame = new JFrame();
        frame.setBounds(200, 50, 1000, 700);
        frame.setResizable(false);
        frame.setTitle("TRiCKLE BANK");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon image = new ImageIcon("test.png");
        frame.setIconImage(image.getImage());
        
        panel = new JPanel();
        panel.setBounds(5,5,975,652);
        panel.setLayout(null);
        //panel.setBackground(Color.gray);
        
        l1 = new JLabel("WELCOME TO TRiCKLE BANK");
        l1.setBounds(250,90,500,25);
        l1.setFont(new Font("Serif ",Font.BOLD,30));
        
        dc = new JButton("DEBIT CARD");
        dc.setBounds(330,225,300,50);
        dc.setBackground(new Color(200,215,60));
        dc.setBorder(null);
        dc.addActionListener(this);
        
        cc = new JButton("CREDIT CARD");
        cc.setBounds(330,300,300,50);
        cc.setBackground(new Color(255,215,0));
        cc.setBorder(null);
        cc.addActionListener(this);
        
        //Debit Card Panel
        dpanel = new JPanel();
        dpanel.setBounds(5,5,975,652);
        dpanel.setLayout(null);
        //dpanel.setBackground(new Color(15,130,200));
         
        debit = new JLabel("DEBIT CARD");
        debit.setBounds(400,40,300,70);
        debit.setFont(new Font("serif",Font.BOLD,30));
        debit.setForeground(new Color(128,0,0));
        
        card__id = new JLabel("Card ID:");
        card__id.setBounds(70,150,200,50);
        card__id.setFont(new Font("serif",Font.PLAIN,22));
        //card__id.setForeground(Color.blue);
        
        client__name = new JLabel("Client Name:");
        client__name.setBounds(70,200,200,50);
        client__name.setFont(new Font("serif",Font.PLAIN,22));
        //client__name.setForeground(Color.blue);
        
        issuer__bank = new JLabel("Issuer Bank:");
        issuer__bank.setBounds(70,250,200,50);
        issuer__bank.setFont(new Font("serif",Font.PLAIN,22));
        //issuer__bank.setForeground(Color.blue);
        
        c_i = new JTextField();
        c_i.setBounds(230,160,180,30);
        c_i.setBackground(new Color(216,187,187));
        c_i.setForeground(new Color(10,101,53));
        c_i.setFont(new Font("serif",Font.PLAIN,22));
        c_i.setBorder(null);
        
        c_n = new JTextField();
        c_n.setBounds(230,210,180,30);
        c_n.setBackground(new Color(216,187,187));
        c_n.setForeground(new Color(58,84,216));
        c_n.setFont(new Font("serif",Font.PLAIN,22));
        c_n.setBorder(null);
        
        i_b = new JTextField();
        i_b.setBounds(230,260,180,30);
        i_b.setBackground(new Color(216,187,187));
        i_b.setForeground(new Color(58,84,216));
        i_b.setFont(new Font("serif",Font.PLAIN,22));
        i_b.setBorder(null);
        
        bank__account = new JLabel("Bank Account:");
        bank__account.setBounds(525,150,200,50);
        bank__account.setFont(new Font("serif",Font.PLAIN,22));
        //bank__account.setForeground(Color.blue);
        
        balance__amount = new JLabel("Balance Amount:");
        balance__amount.setBounds(525,200,200,50);
        balance__amount.setFont(new Font("serif",Font.PLAIN,22));
        //balance__amount.setForeground(Color.blue);
        
        pin__number = new JLabel("PIN Number:");
        pin__number.setBounds(525,250,200,50);
        pin__number.setFont(new Font("serif",Font.PLAIN,22));
        //pin__number.setForeground(Color.blue);
        
        b_a = new JTextField();
        b_a.setBounds(740,160,180,30);
        b_a.setBackground(new Color(216,187,187));
        b_a.setForeground(new Color(58,84,216));
        b_a.setFont(new Font("serif",Font.PLAIN,22));
        b_a.setBorder(null);
        
        b_am = new JTextField();
        b_am.setBounds(740,210,180,30);
        b_am.setBackground(new Color(216,187,187));
        b_am.setForeground(new Color(58,84,216));
        b_am.setFont(new Font("serif",Font.PLAIN,22));
        b_am.setBorder(null);
        
        pin_num = new JPasswordField();
        pin_num.setBounds(740,260,180,30);
        pin_num.setBackground(new Color(216,187,187));
        pin_num.setForeground(new Color(243,18,18));
        pin_num.setFont(new Font("serif",Font.PLAIN,22));
        pin_num.setBorder(null);
        
        back = new JButton("Back ↩");
        back.setBounds(100,65,80,30);
        back.setFont(new Font("serif",Font.BOLD,12));
        back.setBackground(new Color(18,45,79));
        back.setForeground(Color.white);
        back.addActionListener(this);
        
        d_disp = new JButton("Display");
        d_disp.setBounds(740,310,180,40);
        d_disp.setFont(new Font("serif",Font.PLAIN,22));
        //d_disp.setBackground(new Color(119,115,58));
        d_disp.setBorder(null);
        d_disp.addActionListener(this);
        
        d_add_deb = new JButton("Add Debit Card");
        d_add_deb.setBounds(230,320,180,40);
        d_add_deb.setFont(new Font("serif",Font.PLAIN,22));
        d_add_deb.setBorder(null);
        //d_add_deb.setBackground(new Color(58,71,119));
        d_add_deb.addActionListener(this);
        
        w_am = new JLabel("Withdrawal Amount:");
        w_am.setBounds(70,410,200,50);
        w_am.setFont(new Font("serif",Font.PLAIN,22));
        
        d_w_am = new JTextField();
        d_w_am.setBounds(280,420,180,30);
        d_w_am.setBackground(new Color(216,187,187));
        d_w_am.setForeground(new Color(4,122,32));
        d_w_am.setFont(new Font("serif",Font.PLAIN,22));
        d_w_am.setBorder(null);
        
        d_o_w = new JLabel("Date of withdrawal:");
        d_o_w.setBounds(70,460,200,50);
        d_o_w.setFont(new Font("serif",Font.PLAIN,22));
        
        d_d_o_w = new JComboBox();
        d_d_o_w.setBounds(280,470,50,30);
        int days = 0;
        for (int i=1; i<=32; i++) {
            days = i;
            d_d_o_w.addItem(days);
        }
        
        String m_list [] = {"Jan","Feb","Mar","Apr","May","Jun","Jul", "Aug","Sept","Oct","Nov","Dec"};
        m_d_o_w = new JComboBox(m_list);
        m_d_o_w.setBounds(340,470,50,30);
        //m_d_o_w.addItem(m_list);
        
        y_d_o_w = new JComboBox();
        y_d_o_w.setBounds(400,470,60,30);
        for (int i = 2023; i>=1993; i--) {
            y_d_o_w.addItem(i);
        }

        d_clear = new JButton("Clear");
        d_clear.setBounds(850,420,70,30);
        d_clear.setBackground(new Color(149,74,79));
        d_clear.setForeground(Color.white);
        d_clear.addActionListener(this);
        
        withdrw = new JButton("Withdraw");
        withdrw.setBounds(740,470,180,40);
        withdrw.setFont(new Font("serif",Font.PLAIN,22));
        withdrw.setBackground(new Color(151,255,196));
        withdrw.setBorder(null);
        withdrw.addActionListener(this);
        
        
        
        
        //Credit Card Panel
        cpanel = new JPanel();
        cpanel.setBounds(5,5,975,652);
        cpanel.setLayout(null);
        //cpanel.setBackground(Color.blue);
        
        back2 = new JButton("Back ↩");
        back2.setBounds(100,65,80,30);
        back2.setFont(new Font("serif",Font.BOLD,12));
        back2.setBackground(new Color(18,45,79));
        back2.setForeground(Color.white);
        back2.addActionListener(this);
        
        credit = new JLabel("CREDIT CARD");
        credit.setBounds(400,40,300,70);
        credit.setFont(new Font("serif",Font.BOLD,30));
        credit.setForeground(new Color(128,0,0));
        
        c_card__id = new JLabel("Card ID:");
        c_card__id.setBounds(70,150,200,50);
        c_card__id.setFont(new Font("serif",Font.PLAIN,22));
        //c_card__id.setForeground(Color.blue);
        
        c_client__name = new JLabel("Client Name:");
        c_client__name.setBounds(70,200,200,50);
        c_client__name.setFont(new Font("serif",Font.PLAIN,22));
        //c_client__name.setForeground(Color.blue);
        
        c_issuer__bank = new JLabel("Issuer Bank:");
        c_issuer__bank.setBounds(70,250,200,50);
        c_issuer__bank.setFont(new Font("serif",Font.PLAIN,22));
        //c_issuer__bank.setForeground(Color.blue);
        
        c_c_i = new JTextField();
        c_c_i.setBounds(230,160,180,30);
        c_c_i.setBackground(new Color(216,187,187));
        c_c_i.setForeground(new Color(10,101,53));
        c_c_i.setFont(new Font("serif",Font.PLAIN,22));
        c_c_i.setBorder(null);
        
        c_c_n = new JTextField();
        c_c_n.setBounds(230,210,180,30);
        c_c_n.setBackground(new Color(216,187,187));
        c_c_n.setForeground(new Color(58,84,216));
        c_c_n.setFont(new Font("serif",Font.PLAIN,22));
        c_c_n.setBorder(null);
        
        c_i_b = new JTextField();
        c_i_b.setBounds(230,260,180,30);
        c_i_b.setBackground(new Color(216,187,187));
        c_i_b.setForeground(new Color(58,84,216));
        c_i_b.setFont(new Font("serif",Font.PLAIN,22));
        c_i_b.setBorder(null);
        
        c_bank__account = new JLabel("Bank Account:");
        c_bank__account.setBounds(525,150,200,50);
        c_bank__account.setFont(new Font("serif",Font.PLAIN,22));
        //c_bank__account.setForeground(Color.blue);
        
        c_balance__amount = new JLabel("Balance Amount:");
        c_balance__amount.setBounds(525,200,200,50);
        c_balance__amount.setFont(new Font("serif",Font.PLAIN,22));
        //c_balance__amount.setForeground(Color.blue);
        
        cvc__number = new JLabel("CVC Number:");
        cvc__number.setBounds(525,250,200,50);
        cvc__number.setFont(new Font("serif",Font.PLAIN,22));
        //cvc__number.setForeground(Color.blue);
        
        c_b_a = new JTextField();
        c_b_a.setBounds(740,160,180,30);
        c_b_a.setBackground(new Color(216,187,187));
        c_b_a.setForeground(new Color(58,84,216));
        c_b_a.setFont(new Font("serif",Font.PLAIN,22));
        c_b_a.setBorder(null);
        
        c_b_am = new JTextField();
        c_b_am.setBounds(740,210,180,30);
        c_b_am.setBackground(new Color(216,187,187));
        c_b_am.setForeground(new Color(58,84,216));
        c_b_am.setFont(new Font("serif",Font.PLAIN,22));
        c_b_am.setBorder(null);
        
        cvc_num = new JPasswordField();
        cvc_num.setBounds(740,260,180,30);
        cvc_num.setBackground(new Color(216,187,187));
        cvc_num.setForeground(new Color(243,18,18));
        cvc_num.setFont(new Font("serif",Font.PLAIN,22));
        cvc_num.setBorder(null);
        
        add_c_c = new JButton("Add Credit Card");
        add_c_c.setBounds(230,370,180,40);
        add_c_c.setFont(new Font("serif",Font.PLAIN,20));
        add_c_c.setBackground(new Color(150,150,200));
        add_c_c.setBorder(null);
        add_c_c.addActionListener(this);
        
        cancel_cc = new JButton("Cancel Credit Card");
        cancel_cc.setBounds(740,370,180,40);
        cancel_cc.setFont(new Font("serif",Font.PLAIN,20));
        cancel_cc.setBackground(new Color(255,190,190));
        cancel_cc.setBorder(null);
        cancel_cc.addActionListener(this);
        
        int_rate = new JLabel("Interest Rate");
        int_rate.setBounds(70,300,200,50);
        int_rate.setFont(new Font("serif",Font.PLAIN,22));
        
        c_int_r = new JTextField();
        c_int_r.setBounds(230,310,180,30);
        c_int_r.setBackground(new Color(216,187,187));
        c_int_r.setForeground(new Color(4,122,32));
        c_int_r.setFont(new Font("serif",Font.PLAIN,22));
        c_int_r.setBorder(null);
        
        c_grace_p = new JLabel("Grace Period");
        c_grace_p.setBounds(70,460,200,50);
        c_grace_p.setFont(new Font("serif",Font.PLAIN,22));

        c_gr_p = new JTextField();
        c_gr_p.setBounds(230,470,180,30);
        c_gr_p.setBackground(new Color(216,187,187));
        c_gr_p.setForeground(new Color(4,122,32));
        c_gr_p.setFont(new Font("serif",Font.PLAIN,22));
        c_gr_p.setBorder(null);
        
        c_credit_l = new JLabel("Credit Limit");
        c_credit_l.setBounds(70,510,200,50);
        c_credit_l.setFont(new Font("serif",Font.PLAIN,22));
        
        c_cr_l = new JTextField();
        c_cr_l.setBounds(230,520,180,30);
        c_cr_l.setBackground(new Color(216,187,187));
        c_cr_l.setForeground(new Color(4,122,32));
        c_cr_l.setFont(new Font("serif",Font.PLAIN,22));
        c_cr_l.setBorder(null);
        
        c_expiration_d = new JLabel("Expiration Date");
        c_expiration_d.setBounds(525,300,200,50);
        c_expiration_d.setFont(new Font("serif",Font.PLAIN,22));
        //c_expiration_d.setForeground(Color.blue);
        
        c_exp_d = new JComboBox();
        c_exp_d.setBounds(740,310,50,30);
        int day= 0;
        for (int i=1; i<=32; i++) {
            day = i;
            c_exp_d.addItem(day);
        }
        
        //String n_list [] = {"Jan","Feb","Mar","Apr","May","Jun","Jul", "Aug","Sept","Oct","Nov","Dec"};
        c_exp_m = new JComboBox(m_list);
        c_exp_m.setBounds(800,310,50,30);
        //n_d_o_w.addItem(m_list);
        
        c_exp_y = new JComboBox();
        c_exp_y.setBounds(860,310,60,30);
        for (int i = 2027; i>=1993; i--) {
            c_exp_y.addItem(i);
        }
        
        c_clear = new JButton("Clear");
        c_clear.setBounds(850,470,70,30);
        c_clear.setBackground(new Color(149,74,79));
        c_clear.setForeground(Color.white);
        c_clear.addActionListener(this);
        
        s_cr_l = new JButton("Set Credit Limit");
        s_cr_l.setBounds(525,520,180,40);
        s_cr_l.setFont(new Font("serif",Font.PLAIN,20));
        s_cr_l.setBackground(new Color(150,200,150));
        s_cr_l.setBorder(null);
        s_cr_l.addActionListener(this);
        
        c_disp = new JButton("Display");
        c_disp.setBounds(740,520,180,40);
        c_disp.setFont(new Font("serif",Font.PLAIN,20));
        c_disp.setBackground(new Color(150,150,150));
        c_disp.setBorder(null);
        c_disp.addActionListener(this);
        
        
        //Debit Card Panel add items
        dpanel.add(withdrw);
        dpanel.add(d_clear);
        dpanel.add(y_d_o_w);
        dpanel.add(m_d_o_w);
        dpanel.add(d_d_o_w);
        dpanel.add(d_o_w);
        dpanel.add(d_w_am);
        dpanel.add(w_am);
        dpanel.add(d_add_deb);
        dpanel.add(d_disp);
        dpanel.add(back);
        dpanel.add(pin_num);
        dpanel.add(b_am);
        dpanel.add(b_a);
        dpanel.add(pin__number);
        dpanel.add(balance__amount);
        dpanel.add(bank__account);
        dpanel.add(i_b);
        dpanel.add(c_n);
        dpanel.add(c_i);
        dpanel.add(issuer__bank);
        dpanel.add(client__name);
        dpanel.add(card__id);
        dpanel.add(debit);
        
        //Credit Card Panel add items
        cpanel.add(s_cr_l);
        cpanel.add(c_disp);
        cpanel.add(c_clear);
        cpanel.add(c_exp_y);
        cpanel.add(c_exp_m);
        cpanel.add(c_exp_d);
        cpanel.add(c_expiration_d);
        cpanel.add(c_credit_l);
        cpanel.add(c_cr_l);
        cpanel.add(c_gr_p);
        cpanel.add(c_grace_p);
        cpanel.add(c_int_r);
        cpanel.add(int_rate);
        cpanel.add(cancel_cc);
        cpanel.add(add_c_c);
        cpanel.add(cvc__number);
        cpanel.add(cvc_num);
        cpanel.add(c_b_a);
        cpanel.add(c_b_am);
        cpanel.add(c_balance__amount);
        cpanel.add(c_bank__account);
        cpanel.add(c_i_b);
        cpanel.add(c_c_n);
        cpanel.add(c_c_i);
        cpanel.add(c_client__name);
        cpanel.add(c_issuer__bank);
        cpanel.add(c_card__id);
        cpanel.add(back2);
        cpanel.add(credit);
        
        //Main Panel add items
        frame.add(dpanel);
        dpanel.setVisible(false);
        frame.add(cpanel);
        cpanel.setVisible(false);
        panel.add(cc);
        panel.add(dc);
        panel.add(l1);
        frame.add(panel);
        frame.setVisible(true);
    }
    
    public static void main(String[]args) {
        BankGUI Gui = new BankGUI();
        Gui.GUI();
    }
    
}
