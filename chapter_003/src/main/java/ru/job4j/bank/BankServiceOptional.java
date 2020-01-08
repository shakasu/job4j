package ru.job4j.bank;

import java.util.*;


public class BankServiceOptional {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!findByPassport(user.getPassport()).isPresent()) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        Account sameAccount = null;
        List<Account> list = this.users.get(findByPassport(passport).get());
        for (Account currentAccount : list) {
            if (account.equals(currentAccount)) {
                sameAccount = currentAccount;
            }
             }
        if (sameAccount == null && findByPassport(passport).isPresent() ) {
            this.users.get(findByPassport(passport).get()).add(account);
        }
    }

    public Optional<User> findByPassport(String passport) {
        User rslUser = null;
        Optional<User> result = Optional.ofNullable(rslUser);
        Set<User> keys = users.keySet();
        for (User user : keys) {
            if (user.getPassport().equals(passport)) {
                rslUser = user;
            }
        }
        return result;
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Account rslAccount = null;
        Optional<Account> result = Optional.ofNullable(rslAccount);
        List<Account> list = this.users.get(findByPassport(passport).get());
        for (Account account : list) {
            if (account.getRequisite().equals(requisite)) {
                rslAccount = account;
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
