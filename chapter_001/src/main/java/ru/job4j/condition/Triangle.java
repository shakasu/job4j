package ru.job4j.condition;

public class Triangle {
    public static boolean exist(double ab, double ac, double bc) {
        boolean tExist;
        if((ab+ac>bc)&&(ab+bc>ac)&&(bc+ac>ab)){
            tExist = true;
        } else {
            tExist = false;
        }
        return tExist;
    }
}
