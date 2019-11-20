package ru.job4j.profession;

import ru.job4j.problem.*;
import ru.job4j.solution.*;

public class Engineer extends Profession {
    public int numberOfTasksSolved;

    public SolvedTask solve(Task task) {
    }

    public Engineer() {
        super();
        System.out.println("Engineer");
    }
}
