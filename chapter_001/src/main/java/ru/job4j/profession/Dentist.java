package ru.job4j.profession;

import ru.job4j.problem.*;
import ru.job4j.solution.*;

public class Dentist extends Doctor {
    public int numberOfTornedTeeth;

    public HealthyPatient pullOut(Tooth tooth) {
    }

    public Dentist() {
        super();
        System.out.println("Dentist");
    }
}
