package ru.job4j.conversion;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(
                Profile::getAddress
        ).collect(Collectors.toList());
    }

    public List<Address> uniqueSortByCity(List<Profile> profileList) {
        return profileList
                .stream()
                .map(
                        Profile::getAddress
                )
                .sorted(new AddressComp())
                .distinct()
                .collect(Collectors.toList());
    }
}
