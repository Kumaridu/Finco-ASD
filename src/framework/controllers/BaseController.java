package framework.controllers;

import framework.account.IAccount;
import framework.owner.Owner;
import framework.utilities.Response;

import java.util.List;

public class BaseController {
    public static Response debit(String accountNumber, Double amount) {
        return Owner.updateAccountBalance(accountNumber, -amount);
    }

    public static Response credit(String accountNumber, Double amount) {
        return Owner.updateAccountBalance(accountNumber, amount);
    }

    public static void applyInterest(){
        Owner.notifyApplyInterest();
    }
    public static List<IAccount> allAccounts(){
        return Owner.getAccounts();
    }
}
