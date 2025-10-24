package java2.lession2_sets_maps_generic;

import java.util.ArrayList;
import java.util.List;

public class Test_generic {
    public static void main(String[] args) {
        Controller<Student> controller = new Controller<>();
        controller.add(new Student("R1", "A"));
        controller.add(new Student("R2", "B"));

        System.out.println(controller.get(0).fullName);
    }
}
