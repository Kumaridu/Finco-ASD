public class JDialog_AddCompAcc extends JDialog_AddAccount
{
    private MainFrm parentframe;
	javax.swing.JTextField JTextField_NoOfEmp = new javax.swing.JTextField();
    
	public JDialog_AddCompAcc(MainFrm parent)
	{
		super(parent, "Add Company Account");
		parentframe = parent;

		setupPrivateComponents();
	}

	private void setupPrivateComponents() {
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36,12,84,24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36,36,84,24);

		JLabel6.setText("No of employees");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12,216,96,24);

		getContentPane().add(JTextField_NoOfEmp);
		JTextField_NoOfEmp.setBounds(120,216,156,20);

	}

	javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();

	@Override
	public void supplementJButtonOkayAP() {
		parentframe.accountnr =JTextField_ACNR.getText();

		if (JRadioButton_Chk.isSelected())
			parentframe.accountType="Ch";
		else
			parentframe.accountType="S";
	}
}