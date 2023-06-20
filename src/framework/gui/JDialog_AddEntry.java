package framework.gui;

public class JDialog_AddEntry extends javax.swing.JDialog{
    private MainWindow parentFrame;
    private String title = "Credit";
    private String accountNumber = "";

    JDialog_AddEntry(MainWindow parentFrame, String accountNumber, String title){
        this.parentFrame  = parentFrame;
        this.title = title;
        this.accountNumber = accountNumber;


        setTitle(this.title);
        setModal(true);
        getContentPane().setLayout(null);
        setSize(266,126);
        setVisible(false);
        JLabel1.setText("Acc Nr");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(12,12,48,24);
        JLabel2.setText("Amount");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(12,48,48,24);
        JTextField_NAME.setEditable(false);
        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(84,12,144,24);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(36,84,84,24);
        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");
        getContentPane().add(JButton_Cancel);
        JButton_Cancel.setBounds(156,84,84,24);
        getContentPane().add(JTextField_Deposit);
        JTextField_Deposit.setBounds(84,48,144,24);
        //}}
        JTextField_NAME.setText(accountNumber);

        //{{REGISTER_LISTENERS
        SymAction lSymAction = new SymAction();
        JButton_OK.addActionListener(lSymAction);
        JButton_Cancel.addActionListener(lSymAction);
        //}}
    }

    //{{DECLARE_CONTROLS
    javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
    javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
    javax.swing.JButton JButton_OK = new javax.swing.JButton();
    javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
    javax.swing.JTextField JTextField_Deposit = new javax.swing.JTextField();
    //}}

    class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            Object object = event.getSource();
            if (object == JButton_OK)
                JButtonOK_actionPerformed(event);
            else if (object == JButton_Cancel)
                JButtonCalcel_actionPerformed(event);
        }
    }

    void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
    {
        parentFrame.amountDeposit = JTextField_Deposit.getText();
        dispose();
    }

    void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
    {
        dispose();
    }
}
