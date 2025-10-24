package java2.lession2_sets_maps_generic;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
    public static void main(String[] args) {
        //Tuong tac len du lieu ve FILE
        //Viet ra phan Window Explorer
        System.out.println(System.getProperty("user.dir"));
//        File file = new File("example.txt");
//        if (file.exists()) {
//            System.out.println("Exists");
//            file.delete();
//        } else {
//            System.out.println("Not");
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

        String filename = "vidu.txt";
        FileOutputStream fos = null;
//        try {
//            //open connection (tao ket noi toi FILE)
//            fos = new FileOutputStream(filename);
//
//            //thuc tao tac doc/ghi du lieu
//            String str = "Hello World!!!";
//            byte[] data;
//            data = str.getBytes("utf8");
//            fos.write(data);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (fos != null) {
//                try {
//                    //dong ket
//                    fos.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);

            int code;
            StringBuilder builder = new StringBuilder();
            while ((code = fis.read())!= -1) {
                //convert code -> ky tu tuong ung
                char c = (char) code;
                builder.append(c);
            }
            System.out.print(builder);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
