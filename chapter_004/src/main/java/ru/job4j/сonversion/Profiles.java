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

    public List<Address> uniqueSortByCity(List<Profile> profileList) {
        List<Address> rls;
        Profiles profiles = new Profiles();
        rls = profiles.collect(profileList);
        rls.sort(new AddressComp());
        return rls.stream().distinct().collect(Collectors.toList());
    }
}
