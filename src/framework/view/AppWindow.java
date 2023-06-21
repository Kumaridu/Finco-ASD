package framework.view;

import framework.gui.MainWindow;
import java.awt.event.ActionEvent;

public class AppWindow extends MainWindow {
    javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
    javax.swing.JButton JButton_CompAC = new javax.swing.JButton();

    public AppWindow(){
        super("Framework Account Application");

        this.setUpAddAccountsButtons();
    }

    private void setUpAddAccountsButtons(){
        JButton_PerAC.setText("Add personal account");
        this.addExtraButton(JButton_PerAC);
        JButton_PerAC.setBounds(24,20,192,33);
        JButton_PerAC.setActionCommand("jbutton");

        JButton_CompAC.setText("Add company account");
        JButton_CompAC.setActionCommand("jbutton");
        this.addExtraButton(JButton_CompAC);
        JButton_CompAC.setBounds(240,20,190,33);

        JButton_PerAC.addActionListener(lSymAction);
        JButton_CompAC.addActionListener(lSymAction);
    }


    @Override
    public String getCreditButtonTitle() {
        return "Credit";
    }

    @Override
    public String getDebitButtonTitle() {
        return "Debit";
    }

    @Override
    public void subActionsPerformed(ActionEvent event) {
        Object object = event.getSource();

        if (object == JButton_PerAC){
            JButtonPerAC_actionPerformed(event);
            return;
        }

        if (object == JButton_CompAC){
            JButtonCompAC_actionPerformed(event);
            return;
        }
    }

    void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event)
    {
        /**
         * Open customized Add Person Aaccount Dialog
         */
        JDialog_AddPAcc pac = new JDialog_AddPAcc(this);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        if (newaccount){
            String[] data = {accountnr, clientName, city, "P", accountType, "0"};
            this.populateTable(data);
        }
    }

    void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event)
    {

        /**
         * Open customized Add Company Account Dialog
         */
        JDialog_AddCompAcc pac = new JDialog_AddCompAcc(this);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        if (newaccount){
            String[] data = {accountnr, clientName, city, "P", accountType, "0"};
            this.populateTable(data);
        }

    }
}
