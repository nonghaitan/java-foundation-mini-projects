package java2.lession3_file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class FileCompressionExample {
    // 🟩 1️⃣ HÀM NÉN FILE
    public static void compressFile(String sourceFile, String compressedFile) {
        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(compressedFile);
                DeflaterOutputStream dos = new DeflaterOutputStream(fos)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, bytesRead);
            }
            System.out.println("✅ Đã nén file: " + sourceFile + " → " + compressedFile);
        } catch (IOException e) {
            throw new RuntimeException("❌ Lỗi khi nén file", e);
        }
    }

    // 🟩 2️⃣ HÀM GIẢI NÉN FILE
    public static void decompressFile(String compressedFile, String outputFile) {
        try (
                FileInputStream fis = new FileInputStream(compressedFile);
                InflaterInputStream iis = new InflaterInputStream(fis);
                FileOutputStream fos = new FileOutputStream(outputFile)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = iis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("✅ Đã giải nén file: " + compressedFile + " → " + outputFile);
        } catch (IOException e) {
            throw new RuntimeException("❌ Lỗi khi giải nén file", e);
        }
    }

    // 🟩 3️⃣ MAIN DEMO
    public static void main(String[] args) {
        String source = "data.txt";                // file gốc
        String compressed = "data.deflated";       // file nén
        String decompressed = "data_out.txt";      // file giải nén

        // Nén file
        compressFile(source, compressed);

        // Giải nén file
        decompressFile(compressed, decompressed);

        System.out.println("\n=== KIỂM TRA KẾT QUẢ ===");
        System.out.println("File gốc:        " + source);
        System.out.println("File nén:        " + compressed);
        System.out.println("File giải nén:   " + decompressed);
    }
}
