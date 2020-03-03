package ru.job4j.converter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public List<Integer> convert(Integer[][] input) {
        return Arrays.stream(input).flatMap(Arrays::stream).collect(Collectors.toList());
    }

    public List<Integer> convert(List<List<Integer>> input) {
        return input.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }
}
