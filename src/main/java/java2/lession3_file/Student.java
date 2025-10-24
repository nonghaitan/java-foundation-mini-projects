package java2.lession3_file;

import java.io.Serializable;

public class Student implements Serializable {
    String fullName, address;

    public Student() {

    }

    public Student(String fullName, String address) {
        this.fullName = fullName;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFileLineFormat() {
        return fullName + "," + address;
    }

    public static String getFileHeaderFormat() {
        return "FullName,Address";
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
