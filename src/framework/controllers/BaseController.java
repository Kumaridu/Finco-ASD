package framework.controllers;

import framework.owner.Owner;
import framework.utilities.Response;

public class BaseController {
    public static Response debit(String accountNumber, Double amount) {
        return Owner.updateAccountBalance(accountNumber, -amount);
    }

    public static Response credit(String accountNumber, Double amount) {
        return Owner.updateAccountBalance(accountNumber, amount);
    }
}
