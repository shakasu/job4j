package ru.job4j.pojo;

import java.util.Date;


public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Shakhnazaryan Karen Surenovich");
        student.setGroup("13424/2");
        student.setAdmission(new Date());


        System.out.println(student.getName() + " entered group number " + student.getGroup() + " on the " + student.getAdmission());
    }
}
