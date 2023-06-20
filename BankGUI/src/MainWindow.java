import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public abstract class MainWindow extends javax.swing.JFrame{
    /****
     * init variables in the object
     ****/
    String accountnr, clientName,street,city,zip,state,accountType,clientType,amountDeposit;
    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    MainWindow myframe;
    private Object rowdata[];
    SymAction lSymAction;
    SymWindow aSymWindow;

    private List<String> tableColumns;


    MainWindow(String title){
        myframe = this;

        setTitle(title);

        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0,0));
        setSize(576,312);
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0,0,584,324);

        /*
		/Add five buttons on the pane
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        this.setTableColumns();
        rowdata = new Object[this.getTableColumns().size()];

        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,440,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);

        JButton_Addinterest.setText("Add interest");
        JPanel1.add(JButton_Addinterest);
        JButton_Addinterest.setBounds(448,20,106,33);

        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468,248,96,30);

        aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        lSymAction = new SymAction();

        JButton_Exit.addActionListener(lSymAction);
        JButton_Addinterest.addActionListener(lSymAction);
    }

    javax.swing.JButton JButton_Addinterest= new javax.swing.JButton();
    javax.swing.JButton JButton_Exit = new javax.swing.JButton();
    javax.swing.JPanel JPanel1 = new javax.swing.JPanel();

    void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event)
    {
        JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);

    }

    abstract List<String> getTableColumns();

    private void setTableColumns(){
        for (String column : this.getTableColumns()){
            model.addColumn(column);
        }

        rowdata = new Object[this.getTableColumns().size()];
        newaccount=false;
    }

    class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            Object object = event.getSource();

            if (object == JButton_Exit){
                JButtonExit_actionPerformed(event);
                return;
            }

            else if (object == JButton_Addinterest){
                JButtonAddinterest_actionPerformed(event);
                return;
            }

            ALAPSub(event);

        }
    }

    public abstract void ALAPSub(java.awt.event.ActionEvent event);

    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
    {
        System.exit(0);
    }

    class SymWindow extends java.awt.event.WindowAdapter
    {
        public void windowClosing(java.awt.event.WindowEvent event)
        {
            Object object = event.getSource();
            if (object == MainWindow.this)
                MainFrm_windowClosing(event);
        }
    }

    void MainFrm_windowClosing(java.awt.event.WindowEvent event)
    {
        // to do: code goes here.

        MainFrm_windowClosing_Interaction1(event);
    }

    void MainFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    void JButtonCredit_actionPerformed(java.awt.event.ActionEvent event, String title)
    {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);

            //Show the dialog for adding deposit amount for the current mane
            JDialog_AddEntry dep = new JDialog_AddEntry(myframe,accnr, title);
            dep.setBounds(430, 15, 275, 140);
            dep.show();

            // compute new amount
            long deposit = Long.parseLong(amountDeposit);
            String samount = (String)model.getValueAt(selection, 5);
            long currentamount = Long.parseLong(samount);
            long newamount=currentamount+deposit;
            model.setValueAt(String.valueOf(newamount),selection, 5);
        }


    }

    void JButtonDebit_actionPerformed(java.awt.event.ActionEvent event, String title)
    {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);

            //Show the dialog for adding withdraw amount for the current mane
            JDialog_AddEntry wd = new JDialog_AddEntry(myframe, accnr, title);
            wd.setBounds(430, 15, 275, 140);
            wd.show();

            // compute new amount
            long deposit = Long.parseLong(amountDeposit);
            String samount = (String)model.getValueAt(selection, 5);
            long currentamount = Long.parseLong(samount);
            long newamount=currentamount-deposit;
            model.setValueAt(String.valueOf(newamount),selection, 5);
            if (newamount <0){
                JOptionPane.showMessageDialog(this, " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void populateTable(String[] data){
        this.getTableColumns();
        for (int i = 0; i < this.getTableColumns().size() - 1; i++) {
            rowdata[i] = data[i];
        }

        model.addRow(rowdata);
        JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
        newaccount=false;
    }

    void exitApplication()
    {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception ignored) {
        }
    }
}
