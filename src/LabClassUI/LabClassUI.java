package LabClassUI;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class LabClassUI {
    private ArrayList<Student> st = new ArrayList<>();
    private LabClass lc = new LabClass();

    public LabClassUI() {
        initComponents();
        mainFrame.setVisible(true);
    }

    private void searchStudentButtonMouseClicked(MouseEvent e) {
        int rowNumber = lc.searchStudent(nameStudentField.getText(), st);

        StudentTable.clearSelection();
        StudentTable.addRowSelectionInterval(rowNumber, rowNumber);
    }

    private void addStudentMouseClicked(MouseEvent e) {
        addStudentDialog.setVisible(true);
    }

    private void sortStudentMouseClicked(MouseEvent e) {
        lc.sortStudent(st);
        model.setRowCount(0);

        for(Student i: st) {
            model.addRow(new Object[]{i.getName(), String.valueOf(i.getGPA())});
        }
    }

    private void addStudentDialogButtonMouseClicked(MouseEvent e) {
        String name = nameStudentDialogField.getText();
        String gpa = GPAStudentDialogField.getText();

        st.add(new Student(name, Double.parseDouble(gpa)));
        DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();
        model.addRow(new Object[]{name, gpa});
    }

    private void initComponents() {
        mainFrame = new JFrame();
        mainTablePanel = new JPanel();
        tableScroll = new JScrollPane();

        model = new DefaultTableModel();
        model.addColumn("ФИО студента");
        model.addColumn("GPA студента");
        StudentTable = new JTable(model);
        StudentTable.setEnabled(false);

        searchPanel = new JPanel();
        nameStudentField = new JTextField();
        searchStudentButton = new JButton();
        addStudent = new JButton();
        sortStudent = new JButton();
        addStudentDialog = new JDialog();
        nameStudentDialogField = new JTextField();
        GPAStudentDialogField = new JTextField();
        addStudentDialogButton = new JButton();

        {
            mainFrame.setResizable(false);
            mainFrame.setTitle("LabClassUI");
            mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            var mainFrameContentPane = mainFrame.getContentPane();
            mainFrameContentPane.setLayout(new GridLayout());

            {
                mainTablePanel.setLayout(new MigLayout(
                    "fill,hidemode 3",
                    "[fill]",
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));
                {
                    tableScroll.setViewportView(StudentTable);
                }
                mainTablePanel.add(tableScroll, "cell 0 1");

                {
                    searchPanel.setLayout(new MigLayout(
                        "fill,hidemode 3",
                        "[fill]" +
                        "[fill]",
                        "[]" +
                        "[]"));

                    nameStudentField.setToolTipText("ФИО студента");
                    nameStudentField.setText("ФИО студента");
                    searchPanel.add(nameStudentField, "cell 0 0");

                    searchStudentButton.setText("Найти студента по ФИО");
                    searchStudentButton.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            searchStudentButtonMouseClicked(e);
                        }
                    });
                    searchPanel.add(searchStudentButton, "cell 1 0");
                }
                mainTablePanel.add(searchPanel, "cell 0 2");

                addStudent.setText("Добавить студента в таблицу");
                addStudent.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        addStudentMouseClicked(e);
                    }
                });
                mainTablePanel.add(addStudent, "cell 0 3");

                sortStudent.setText("Отсортировать таблицу по GPA");
                sortStudent.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        sortStudentMouseClicked(e);
                    }
                });
                mainTablePanel.add(sortStudent, "cell 0 6");
            }
            mainFrameContentPane.add(mainTablePanel);
            mainFrame.pack();
            mainFrame.setLocationRelativeTo(mainFrame.getOwner());
        }

        {
            addStudentDialog.setResizable(false);
            addStudentDialog.setTitle("Добавление нового студента");
            addStudentDialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            var addStudentDialogContentPane = addStudentDialog.getContentPane();
            addStudentDialogContentPane.setLayout(new MigLayout(
                "fill,hidemode 3",
                "[fill]",
                "[]" +
                "[]" +
                "[]"));

            nameStudentDialogField.setText("ФИО студента");
            nameStudentDialogField.setToolTipText("ФИО студента");
            addStudentDialogContentPane.add(nameStudentDialogField, "cell 0 0");

            GPAStudentDialogField.setText("GPA студента");
            GPAStudentDialogField.setToolTipText("GPA студента");
            addStudentDialogContentPane.add(GPAStudentDialogField, "cell 0 1");

            addStudentDialogButton.setText("Добавить студента");
            addStudentDialogButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    addStudentDialogButtonMouseClicked(e);
                }
            });
            addStudentDialogContentPane.add(addStudentDialogButton, "cell 0 2");
            addStudentDialog.pack();
            addStudentDialog.setLocationRelativeTo(addStudentDialog.getOwner());
        }
    }

    private JFrame mainFrame;
    private JPanel mainTablePanel;
    private JScrollPane tableScroll;
    private DefaultTableModel model;
    private JTable StudentTable;
    private JPanel searchPanel;
    private JTextField nameStudentField;
    private JButton searchStudentButton;
    private JButton addStudent;
    private JButton sortStudent;
    private JDialog addStudentDialog;
    private JTextField nameStudentDialogField;
    private JTextField GPAStudentDialogField;
    private JButton addStudentDialogButton;
}
