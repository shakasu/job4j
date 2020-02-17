package ru.job4j.counter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class RangeCount {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<Double>();
        for (int index = start; index != end; index++) {
            result.add(func.apply((double) index));
        }
        return result;
    }
}
