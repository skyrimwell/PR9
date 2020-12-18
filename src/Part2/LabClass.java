package Part2;

public class LabClass implements SortAndSearchStudent {
    @Override
    public void sortStudent(Student[] arr) throws EmptyStringException {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            double key = arr[i].getGPA();
            String sKey = arr[i].getName();
            int j = i - 1;

            while (j >= 0 && arr[j].getGPA() > key) {
                arr[j + 1].setGPA(arr[j].getGPA());
                arr[j + 1].setName(arr[j].getName());
                j = j - 1;
            }
            arr[j + 1].setGPA(key);
            arr[j + 1].setName(sKey);
        }
    }

    @Override
    public int searchStudent(String sub, Student[] arr) throws StudentNotFoundException, EmptyStringException {
        if (sub == null || sub.isEmpty())
            throw new EmptyStringException("Искомая строка не может быть пустой!");

        int count = 0;
        for(Student i: arr) {
            if(sub.equals(i.getName()))
                return count;
            count++;
        }
        throw new StudentNotFoundException("ФИО студента не найдено!");
    }
}
