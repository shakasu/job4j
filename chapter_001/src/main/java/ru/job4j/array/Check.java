package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean tmp = false; // tmp будет присваивать эталонное значение
       for (int index = 0; index!=data.length; index++) {
           if (index==0) { //tmp присваивает эталонное значение только у нулевого элемента
               tmp = data[index];
           }
           if (tmp != data[index]){ // Если хотя бы один элемент не равен tmp,
               // нет смысла продолжать цикл
               result = false;
               break;
           }
       }
        return result;
    }
}