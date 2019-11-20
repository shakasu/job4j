package ru.job4j.profession;

import ru.job4j.problem.*;
import ru.job4j.solution.*;

public class Builder extends Engineer {
    public int numberOfHousesBuilt;

    public SolvedTask build(House house) {
    }

    public Builder() {
        super();
        System.out.println("Builder");
    }
}
