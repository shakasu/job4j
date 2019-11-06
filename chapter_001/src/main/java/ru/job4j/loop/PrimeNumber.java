package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        CheckPrimeNumber ourNumber = new CheckPrimeNumber();
        boolean truePrime = false;
        for(int index =1;index<(finish+1);index++){
            if(truePrime = ourNumber.check(index)){
                count++;
            }
        }
        return count;
    }
}