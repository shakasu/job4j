package ru.job4j.conversion;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void collectTest() {

        Address address1 = new Address("Moscow", "lelina", 23, 5);
        Address address2 = new Address("SPb", "pushkina", 233, 51);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        List<Profile> profileList = List.of(profile1, profile2);
        List<Address> addressList = List.of(address1, address2);
        Profiles profiles = new Profiles();
        assertThat(profiles.collect(profileList), is(addressList));
    }

    @Test
    public void uniqueSortByCityTest() {
        Address address1 = new Address("Abakan", "lelina", 23, 5);
        Address address2 = new Address("Belgorod", "pushkina", 233, 51);
        Address address3 = new Address("Belgorod", "pushkina", 233, 51);
        Address address4 = new Address("City", "mira", 100, 52);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        Profile profile3 = new Profile(address3);
        Profile profile4 = new Profile(address4);
        List<Profile> profileList = List.of(profile2, profile4, profile3, profile1);
        List<Address> addressList = List.of(address1, address2, address4);
        Profiles profiles = new Profiles();
        assertThat(profiles.uniqueSortByCity(profileList), is(addressList));
    }

}
