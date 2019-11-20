package ru.job4j.profession;

import ru.job4j.problem.*;
import ru.job4j.solution.*;

public class Surgeon extends Doctor {
    public int numberOfPatientsOperated;

    public HealthyPatient medicalIntervention(Operation operation) {
    }

    public Surgeon() {
        super();
        System.out.println("Surgeon");
    }
}
