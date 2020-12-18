package LabClassUI;

import java.util.ArrayList;

public class LabClass implements SortAndSearchStudent {
    @Override
    public void sortStudent(ArrayList<Student> arr) {
        int n = arr.size();
        for (int i = 1; i < n; ++i) {
            double key = arr.get(i).getGPA();
            String sKey = arr.get(i).getName();
            int j = i - 1;

            while (j >= 0 && arr.get(j).getGPA() > key) {
                arr.get(j + 1).setGPA(arr.get(j).getGPA());
                arr.get(j + 1).setName(arr.get(j).getName());
                j = j - 1;
            }
            arr.get(j + 1).setGPA(key);
            arr.get(j + 1).setName(sKey);
        }
    }

    @Override
    public int searchStudent(String sub, ArrayList<Student> arr) {
        int count = 0;
        for(Student i: arr) {
            if(sub.equals(i.getName()))
                return count;
            count++;
        }
        return -1;
    }
}
