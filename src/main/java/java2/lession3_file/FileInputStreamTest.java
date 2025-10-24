package java2.lession3_file;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("test.txt");
            int code;

            StringBuilder builder = new StringBuilder();
            while ((code = fis.read()) != -1) {
                builder.append((char) code);
            }

            System.out.print(builder);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
