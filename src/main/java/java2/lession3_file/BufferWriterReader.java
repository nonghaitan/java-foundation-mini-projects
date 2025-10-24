package java2.lession3_file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BufferWriterReader {
    public static void main(String[] args) {
        List<Student> studentList = List.of(
                new Student("A", "Ha Noi"),
                new Student("B", "Ha Nam"),
                new Student("C", "Nam Dinh")
        );

        // Cach 1. ghi dung bufferWriter
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Student.txt"))) {
//            String lineHeader = Student.getFileHeaderFormat() + "\n";
//            writer.write(lineHeader);
//            for (Student std : studentList) {
//                writer.write(std.getFileLineFormat());
//                writer.newLine(); // tự thêm \n
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        // Cach 2. ghi dung Files.write()
        List<String> studentLines = studentList.stream().map(Student::getFileLineFormat).toList();

        List<String> linesWithHeader = new ArrayList<>();
        linesWithHeader.add(Student.getFileHeaderFormat()); // header
        linesWithHeader.addAll(studentLines);

        try {
            Files.write(Path.of("Student.txt"), linesWithHeader, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Doc du lieu
        // Cach 1 BufferedReader
//        try (BufferedReader reader = new BufferedReader(new FileReader("Student.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line); // in từng dòng
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        // Cach 2 Files.lines
        try {
            Files.lines(Path.of("Student.txt"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
