package java2.lession3_file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileAndFileOutStream {
    public static void main(String[] args) {
        // Phan1: File Class
        System.out.println(System.getProperty("user.dir"));
//        File file = new File("vidu.txt");
//        if (file.exists()) {
//            System.out.println("Exists");
//        } else {
//            System.out.println("Not");
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

        //Phan 2: Ghi du lieu vao file
        FileOutputStream fos = null;
        Scanner scanner = new Scanner(System.in);

        try {
//            fos = new FileOutputStream("test.txt"); // ghi đè file
            fos = new FileOutputStream("test.txt",true); // append file nếu dữ liệu có sẵn
            for (; ; ) {
                System.out.println("Insert line to file:");
                String line = scanner.nextLine() + "\n";
                byte[] b = line.getBytes();
                fos.write(b);
                System.out.println("Contine Y/N");
                String choose = scanner.nextLine();
                if (choose.equalsIgnoreCase("N")) {
                    break;
                }
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
