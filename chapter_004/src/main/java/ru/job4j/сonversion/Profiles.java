package ru.job4j.сonversion;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> rls;
        rls = profiles.stream().map(
                Profile::getAddress
        ).collect(Collectors.toList());
        return rls;
    }

    public List<Address> uniqueSortByCity(List<Profile> profiles) {
        List<Address> tmp;
        tmp = profiles.stream().map(
                Profile::getAddress
        ).collect(Collectors.toList());
        tmp.sort(new AddressComp());
        List<Address> rls = tmp.stream().distinct().collect(Collectors.toList());
        return rls;
    }
}
