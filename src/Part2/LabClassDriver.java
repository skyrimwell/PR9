package Part2;

public class LabClassDriver {
    public static void main(String[] args) throws EmptyStringException, StudentNotFoundException {
        Student[] s = new Student[5];
        LabClass lc = new LabClass();

        s[0] = new Student("Ivan", 10.2);
        s[1] = new Student("ww", 2.2);
        s[2] = new Student("ff", 2.3);
        s[3] = new Student("Issa", 11.2);
        s[4] = new Student("Wwafn", 110.2);

        for(Student i: s) {
            System.out.println(i);
        }

        System.out.println("\n");

        lc.sortStudent(s);
        for(Student i: s) {
            System.out.println(i);
        }

        System.out.println("\n");

        System.out.println(lc.searchStudent("", s));

    }
}
