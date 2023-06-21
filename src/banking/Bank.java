package banking;

import banking.account.BankController;
import banking.view.BankWindow;

import javax.swing.*;

public class Bank {


    public static void main(String[] args) {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            // Create a new instance of our application's frame, and make it visible.
            (new BankWindow(new BankController())).setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            // Ensure the application exits with an error condition.
            System.exit(1);
        }
    }
}