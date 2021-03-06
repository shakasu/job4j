package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class BankServiceOptionalTest {

    @Test
    public void addUser() {
        User user = new User("12051997", "Karen S");
        BankServiceOptional bank = new BankServiceOptional();
        bank.addUser(user);
        assertThat(bank.findByPassport("12051997").get(), is(user));
    }

    @Test
    public void deleteUser() {
        User user = new User("12051997", "Karen S");
        BankServiceOptional bank = new BankServiceOptional();
        bank.addUser(user);
        bank.deleteUser(user.getPassport());
        assertFalse(bank.findByPassport("12051997").isPresent());
    }

    @Test
    public void addAccount() {
        User user = new User("12051997", "Karen S");
        double expected = 150000;
        BankServiceOptional bank = new BankServiceOptional();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("qwe123", 150000));
        assertThat(bank.findByRequisite("12051997", "qwe123").get().getBalance(), is(expected));
    }

    @Test
    public void transferMoney() {
        User user = new User("12051997", "Karen S");
        double expected = 150000;
        BankServiceOptional bank = new BankServiceOptional();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("qwe123", 100000));
        bank.addAccount(user.getPassport(), new Account("qwe456", 50000));
        bank.transferMoney(user.getPassport(), "qwe123", user.getPassport(), "qwe456", 100000);
        assertThat(bank.findByRequisite("12051997", "qwe456").get().getBalance(), is(expected));
    }

    @Test
    public void findByRequisite() {
        User user = new User("12051997", "Karen S");
        BankService bank = new BankService();
        bank.addUser(user);
        double expected = 100000;
        bank.addAccount(user.getPassport(), new Account("qwe123", 100000));
        assertThat(bank.findByRequisite("12051997", "qwe123").getBalance(), is(expected));
    }
}
