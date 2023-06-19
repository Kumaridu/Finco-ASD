package framework.owner;

import framework.account.IAccount;

import java.util.List;

public abstract class Owner {

    private static String name = "CompanyX";
    private static String email = "companyx@gmail.com";
    private static List<IAccount> accounts;

    public static String getName() {
        return name;
    }

    public static String getEmail() {
        return email;
    }

    public static void setName(String name) {
        Owner.name = name;
    }

    public static void setEmail(String email) {
        Owner.email = email;
    }

    public void addAccount(IAccount account) {
        accounts.add(account);
    }

    /**
     * Notify all accounts to apply interest
     */
    public void applyInterest(){
        for (IAccount account : accounts){
            account.addInterest();
        }
    }





}
