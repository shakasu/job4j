package ru.job4j.bank;

import java.util.*;

public class BankServiceOptional {

    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        findByPassport(passport).ifPresent(value -> this.users.remove(value));
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream().filter(
                e -> e.getPassport().equals(passport)
        ).findFirst();
    }

    public void addAccount(String passport, Account account) {
        findByPassport(passport)
                .filter(e -> !users.get(e).contains(account))
                .ifPresent(e -> users.get(e).add(account));
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        return findByPassport(passport)
                .stream()
                .flatMap(e -> users.get(e).stream())
                .filter(e -> e.getRequisite().equals(requisite))
                .findFirst();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (
                srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount
        ) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
