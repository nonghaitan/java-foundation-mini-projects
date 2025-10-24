package java2.lession3_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectInOutputSteam {
    public static void main(String[] args) {
//       saveFile();
        readFile();
    }

    static void saveFile() {
        List<Student> studentList = List.of(
                new Student("A", "Ha Noi"),
                new Student("B", "Ha Nam"),
                new Student("C", "Nam Dinh")
        );

        try (FileOutputStream fos = new FileOutputStream("Student.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(studentList);
            for (Student student : studentList) {
                oos.writeObject(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readFile() {
        try (FileInputStream fis = new FileInputStream("Student.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // đọc object và ép kiểu về List<Student> - 1 lần cả list
//            List<Student> students = (List<Student>) ois.readObject(); // sửa tên phương thức và thêm cast

            // đọc object từng student 1
            List<Student> students = new ArrayList<>();
            while (true) { // đọc đến khi hết file
                try {
                    Student std = (Student) ois.readObject();
                    students.add(std);
                } catch (EOFException e) {
                    // 🔹 Khi hết file thì thoát vòng lặp
                    break;
                }
            }

            // in ra để kiểm tra
            students.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {  // thêm ClassNotFoundException
            throw new RuntimeException(e);
        }
    }
}
