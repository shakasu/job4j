package ru.job4j.сonversion;

public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int rsl = 1;
        rsl = prime * rsl + ((city != null) ? 0 : city.hashCode());
        rsl = prime * rsl + ((street != null) ? 0: street.hashCode());
        rsl = prime * rsl + apartment;
        rsl = prime * rsl + home;
        return rsl;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Address address = (Address) obj;
        return home == address.home && apartment == address.apartment &&
                (city == address.city || (city != null && city.equals(address.getCity()))) &&
                (street == address.street || (street != null && street.equals(address.getStreet())));
    }
}