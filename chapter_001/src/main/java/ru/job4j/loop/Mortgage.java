package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int salary, double percent) {
        int year = 0;
        double doubleAmount = amount;
        while(doubleAmount>=0){
            doubleAmount =doubleAmount*(1+percent/100);
            doubleAmount=doubleAmount-salary;
            year++;
        }

        return year;
    }
}