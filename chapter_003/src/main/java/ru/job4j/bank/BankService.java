package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (findByPassport(user.getPassport()) == null) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        Account sameAccount = null;
        if (user != null) {
            List<Account> list = this.users.get(user);
            for (Account currentAccount : list) {
                if (account.equals(currentAccount)) {
                    sameAccount = currentAccount;
                }
             }
        }
        if (sameAccount == null) {
            this.users.get(findByPassport(passport)).add(account);
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        Set<User> keys = users.keySet();
        for (User user : keys) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        List<Account> list = this.users.get(user);
        for (Account account : list) {
            if (user != null && account.getRequisite().equals(requisite)) {
                rsl = account;
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        User srcUser = findByPassport(srcPassport);
        User destUser = findByPassport(destPassport);
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcUser != null &&
                destUser != null &&
                srcAccount != null &&
                destAccount != null &&
                srcAccount.getBalance() >= amount ) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
