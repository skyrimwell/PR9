package Part2;

public interface SortAndSearchStudent {
    void sortStudent(Student[] arr) throws EmptyStringException;
    int searchStudent(String sub, Student[] arr) throws StudentNotFoundException, EmptyStringException;
}
