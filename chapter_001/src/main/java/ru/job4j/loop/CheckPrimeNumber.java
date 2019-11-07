package ru.job4j.loop;

public class CheckPrimeNumber {
    public boolean check(int finish) {
        if (finish == 0){
            return false;
        }
        boolean prime = true;
        int filter = 0;
        for(int index=1;index<=finish;index ++){
            if ((finish%index)==0){
               filter++;
            }
            if (filter>2) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}