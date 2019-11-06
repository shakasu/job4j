package ru.job4j.loop;

public class CheckPrimeNumber {
    public boolean check(int finish) {
        if (finish == 0){
            return false;
        }
        boolean prime = false;
        int filter = 0;
        for(int index=1;index<=finish;index ++){
            if ((finish%index)==0){
               filter++;
            }
            if (filter>2) {
                break;
            }
        }
        prime= filter==2? true:false;
        return prime;
    }
}