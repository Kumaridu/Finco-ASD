package creditcard;

import creditcard.view.CreditCardMainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            /**
             * Load Account Manager Window(View)
             */
            (new CreditCardMainWindow()).setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            // Ensure the application exits with an error condition.
            System.exit(1);
        }
    }
}