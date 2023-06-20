import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * A basic JFC based application.
 **/
public class MainFrm extends MainWindow
{
	MainFrm mainFrm;
	public MainFrm()
	{
		super("Bank Account");
		mainFrm = this;

		JButton_PerAC.setText("Add personal account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24,20,192,33);
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240,20,190,33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468,104,96,33);
		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);

		JButton_Withdraw.setBounds(468,164,96,34);


		JButton_PerAC.setActionCommand("jbutton");


		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		
	}

	
	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[])
	{
		try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }
		    
			//Create a new instance of our application's frame, and make it visible.
			(new MainFrm()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}


	javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();

	@Override
	List<String> getTableColumns() {
		List<String> list = new ArrayList<>();
		list.add("AcctNr");
		list.add("Name");
		list.add("City");
		list.add("P/C");
		list.add("Ch/S");
		list.add("Amount");

		return list;
	}

	@Override
	public void ALAPSub(ActionEvent event) {
		Object object = event.getSource();

		 if (object == JButton_PerAC){
			 JButtonPerAC_actionPerformed(event);
			 return;
		 }

		 if (object == JButton_CompAC){
			 JButtonCompAC_actionPerformed(event);
			 return;
		 }

		if (object == JButton_Deposit){
			JButtonDeposit_actionPerformed(event);
			return;
		}

		if (object == JButton_Withdraw){
			JButtonWithdraw_actionPerformed(event);
			return;
		}

	}


	void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/
		
		JDialog_AddPAcc pac = new JDialog_AddPAcc(mainFrm);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (newaccount){
			String[] data = {accountnr, clientName, city, "P", accountType, "0"};
			this.populateTable(data);
        }
    }

	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 construct a JDialog_AddCompAcc type object
		 set the boundaries and
		 show it
		*/

		JDialog_AddCompAcc pac = new JDialog_AddCompAcc(mainFrm);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (newaccount){
			String[] data = {accountnr, clientName, city, "P", accountType, "0"};
			this.populateTable(data);
        }

	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
	    this.JButtonCredit_actionPerformed(event, "Deposit");
	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
	   this.JButtonDebit_actionPerformed(event, "Withdraw");
	}

}
