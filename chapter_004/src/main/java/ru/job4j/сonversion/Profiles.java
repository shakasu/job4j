package ru.job4j.сonversion;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(
                Profile::getAddress
        ).collect(Collectors.toList());
    }

    public List<Address> uniqueSortByCity(List<Profile> profileList) {
        return new Profiles()
                .collect(profileList)
                .stream()
                .sorted(new AddressComp())
                .distinct()
                .collect(Collectors.toList());
    }
}
