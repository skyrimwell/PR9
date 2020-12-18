package LabClassUI;

public class Student {
    private String name;
    private double GPA;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(double GPA) {
        this.GPA = GPA;
    }

    public Student(String name, double GPA) {
        this.name = name;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Студент " + name + " имеет GPA = " + GPA;
    }
}
