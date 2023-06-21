package creditcard.view;

import framework.gui.JDialog_AddAccount;
import framework.gui.MainWindow;

public class JDialog_AddCreditCardAccount extends JDialog_AddAccount {
    private javax.swing.JRadioButton JRadioButton_Gold = new javax.swing.JRadioButton();
    private javax.swing.JRadioButton JRadioButton_Silver = new javax.swing.JRadioButton();
    private javax.swing.JRadioButton JRadioButton_Bronze = new javax.swing.JRadioButton();

    MainWindow mainWindow;

    public JDialog_AddCreditCardAccount(MainWindow parentForm) {
        super(parentForm, "Add Credit Card Account");

        mainWindow = parentForm;

        setUpprivateComponents();

        //{{REGISTER_LISTENERS
        SymMouse aSymMouse = new SymMouse();
        JRadioButton_Gold.addMouseListener(aSymMouse);
        JRadioButton_Silver.addMouseListener(aSymMouse);


        JRadioButton_Bronze.addMouseListener(aSymMouse);
    }

    private void setUpprivateComponents() {
        JRadioButton_Gold.setText("Gold");
        JRadioButton_Gold.setActionCommand("Checkings");
        getContentPane().add(JRadioButton_Gold);
        JRadioButton_Gold.setBounds(36,12,84,24);
        JRadioButton_Silver.setText("Silver");
        JRadioButton_Silver.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Silver);
        JRadioButton_Silver.setBounds(36,36,84,24);

        JRadioButton_Bronze.setText("Bronze");
        JRadioButton_Bronze.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Bronze);
        JRadioButton_Bronze.setBounds(36,60,84,24);
    }

    class SymMouse extends java.awt.event.MouseAdapter
    {
        public void mouseClicked(java.awt.event.MouseEvent event)
        {
            Object object = event.getSource();
            if (object == JRadioButton_Gold)
                JRadioButtonChk_mouseClicked(event);
            else if (object == JRadioButton_Silver)
                JRadioButtonSav_mouseClicked(event);
            else if (object == JRadioButton_Bronze)
                JRadioButtonBronze_mouseClicked(event);
        }
    }

    void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event)
    {
        JRadioButton_Gold.setSelected(true);
        JRadioButton_Silver.setSelected(false);
        JRadioButton_Bronze.setSelected(false);
    }

    void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event)
    {
        JRadioButton_Gold.setSelected(false);
        JRadioButton_Silver.setSelected(true);
        JRadioButton_Bronze.setSelected(false);

    }
    void JRadioButtonBronze_mouseClicked(java.awt.event.MouseEvent event)
    {
        JRadioButton_Gold.setSelected(false);
        JRadioButton_Silver.setSelected(false);
        JRadioButton_Bronze.setSelected(true);

    }

    @Override
    public void supplementJButtonOkayAP() {
        if (JRadioButton_Gold.isSelected())
            mainWindow.accountType="Gold";
        else{
            if (JRadioButton_Silver.isSelected())
                mainWindow.accountType="Silver";
            else
                mainWindow.accountType="Bronze";
        }
    }
}
