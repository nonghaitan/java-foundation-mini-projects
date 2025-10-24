package java2.lession3_file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class CompressionExample {
    // 🟩 HÀM NÉN (Deflater)
    public static byte[] compress(String data) {
        byte[] input = data.getBytes(StandardCharsets.UTF_8);
        Deflater deflater = new Deflater();
        deflater.setInput(input);
        deflater.finish();

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream(input.length)) {
            byte[] buffer = new byte[1024];
            while (!deflater.finished()) {
                int count = deflater.deflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 🟩 HÀM GIẢI NÉN (Inflater)
    public static String decompress(byte[] compressedData) {
        Inflater inflater = new Inflater();
        inflater.setInput(compressedData);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream(compressedData.length)) {
            byte[] buffer = new byte[1024];
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            return outputStream.toString(StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 🟩 DEMO
    public static void main(String[] args) {
        String originalText = "Hello Java! This is a compression and decompression example using Deflater and Inflater.";
        System.out.println("Original text: " + originalText);

        // Nén
        byte[] compressed = compress(originalText);
        System.out.println("Compressed size: " + compressed.length + " bytes");

        // Giải nén
        String decompressed = decompress(compressed);
        System.out.println("Decompressed text: " + decompressed);
    }
}
