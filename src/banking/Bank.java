package banking;

import banking.view.BankWindow;
import framework.Finco;

import javax.swing.*;

public class Bank extends Finco {
    public static void main(String[] args) {


        Finco.setAppWindow(new BankWindow());
        Finco.main(args);
    }
//    public static void main(String[] args) {
//        try {
//            try {
//                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            } catch (Exception e) {
//            }
//
//            (new BankWindow()).setVisible(true);
//        } catch (Throwable t) {
//            t.printStackTrace();
//
//            System.exit(1);
//        }
//    }
}
