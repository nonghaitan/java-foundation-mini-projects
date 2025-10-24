package java2.lession3_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FileReaderTest {

    public static void main(String[] args) {
        // try-with-resources tự động đóng BufferedReader và FileReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }

        try (var lines = Files.lines(Path.of("test.txt"))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // sql file lớn xử lý ngay khi gặp (;)
        String dbUrl = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "pass";
        Path sqlFile = Path.of("script.sql");

        try (Connection conn = DriverManager.getConnection(dbUrl, username, password);
             Statement stmt = conn.createStatement();
             var lines = Files.lines(sqlFile)) { // Stream tự động đóng file

            StringBuilder sqlBuffer = new StringBuilder();

            lines.forEach(line -> {
                line = line.trim();
                // Bỏ comment hoặc dòng trống
                if (line.isEmpty() || line.startsWith("--") || line.startsWith("//")) return;

                sqlBuffer.append(line).append(" ");

                // Nếu kết thúc câu lệnh
                if (line.endsWith(";")) {
                    String sql = sqlBuffer.toString().trim();
                    try {
                        stmt.execute(sql);
                        System.out.println("Executed: " + sql);
                    } catch (Exception e) {
                        System.err.println("Failed: " + sql);
                        e.printStackTrace();
                    }
                    sqlBuffer.setLength(0); // reset buffer
                }
            });

        } catch (IOException e) {
            throw new RuntimeException("Error reading SQL file", e);
        } catch (Exception e) {
            throw new RuntimeException("Error executing SQL", e);
        }
    }
}

