package java2.lession3_file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class BufferInOutPutStream {
    public static void main(String[] args) throws IOException {
        String file = "Test.txt";
        readUsingBufferedInputStream(file);
        System.out.println("---------------------------------------------------");

        readUsingReadAllBytes(file);
        System.out.println("---------------------------------------------------");

        readUsingReadString(file);
        System.out.println("---------------------------------------------------");

        readUsingBufferedReader(file);
        System.out.println("---------------------------------------------------");

        readUsingFilesLines(file);
        System.out.println("---------------------------------------------------");

//        File file = new File("Test1.txt");
//        if (file.isFile()) {
//            System.out.println("File: " + file.getAbsolutePath());
//            file.delete();
//        } else {
//            System.out.println("Not Found");
//            file.createNewFile();
//        }

//        Scanner input = new Scanner(System.in);
//        System.out.println("Nhap N: ");
//        int N = input.nextInt();

//        DataInputStream inputStream = new DataInputStream(System.in);
//        System.out.println("Nhap N:");
//        int N = Integer.parseInt(inputStream.readLine());
//        System.out.println(N);



    }

    // 🟩 Cách 1: BufferedInputStream + ByteArrayOutputStream (đọc nhị phân)
    public static void readUsingBufferedInputStream(String fileName) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
             ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {

            byte[] data = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(data)) != -1) {
                buffer.write(data, 0, bytesRead);
            }
            String result = buffer.toString(StandardCharsets.UTF_8);
            System.out.println("==> BufferedInputStream:\n" + result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 🟩 Cách 2: Files.readAllBytes()
    public static void readUsingReadAllBytes(String fileName) {
        try {
            byte[] bytes = Files.readAllBytes(Path.of(fileName));
            String result = new String(bytes, StandardCharsets.UTF_8);
            System.out.println("==> Files.readAllBytes:\n" + result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 🟩 Cách 3: Files.readString() (Java 11+)
    public static void readUsingReadString(String fileName) {
        try {
            String result = Files.readString(Path.of(fileName), StandardCharsets.UTF_8);
            System.out.println("==> Files.readString:\n" + result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 🟩 Cách 4: BufferedReader (đọc từng dòng)
    public static void readUsingBufferedReader(String fileName) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName), StandardCharsets.UTF_8)) {
            System.out.println("==> BufferedReader:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 🟩 Cách 5: Files.lines() (Java 8+ Stream API)
    public static void readUsingFilesLines(String fileName) {
        try (Stream<String> lines = Files.lines(Path.of(fileName), StandardCharsets.UTF_8)) {
            System.out.println("==> Files.lines:");
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Cach 6
    public static void readUsingBufferedReaderVar(String fileName) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName), StandardCharsets.UTF_8)) {
            System.out.println("==> BufferedReader (dùng var):");
            var line = reader.readLine();   // var == String ở đây
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
