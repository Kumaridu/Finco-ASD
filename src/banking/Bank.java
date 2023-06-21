package banking;

import banking.view.BankWindow;
import javax.swing.*;

public class Bank {
    public static void main(String[] args) {
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            (new BankWindow()).setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();

            System.exit(1);
        }
    }
}
