package framework;
import framework.view.AppWindow;

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
            (new AppWindow()).setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            // Ensure the application exits with an error condition.
            System.exit(1);
        }
    }
}