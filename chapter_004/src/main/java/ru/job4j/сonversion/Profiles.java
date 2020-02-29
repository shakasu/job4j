package ru.job4j.сonversion;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> rls;
        rls = profiles.stream().map(
                profile -> profile.getAddress()
        ).collect(Collectors.toList());
        return rls;
    }
}
