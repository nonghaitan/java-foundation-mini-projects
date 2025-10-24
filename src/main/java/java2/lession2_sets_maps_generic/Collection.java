package java2.lession2_sets_maps_generic;

import java.util.*;

public class Collection {
    public static void main(String[] args) {
        //Phan 1: Interface list
        //Muc 1:Array List
        //khai bao mang su dung arraylist
        List<String> list = new ArrayList<>();

        //them phan tu
        list.add("A1");
        list.add("A2");
        list.add("A3");

        //xoa
        list.remove(0);
        list.add(0, "A1");
        list.add(2, "AB");
        list.set(2, "ABC");

        //swap phan tu - Chu y
        String tmp = list.get(2);
        list.set(2, list.get(3));
        list.set(3, tmp);

        //duyet phan tu cua mang
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

//        //cach 2
//        for (String item : list) {
//            System.out.println(item);
//
//        }
//
//        //cach 3
//        list.forEach((item) -> {
//            System.out.println(item);
//        });
//
//        //cach4
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            System.out.println(item);
//        }
//
//        //cach 5
//        list.stream().forEach(System.out::println);
//
//        //cach 6 da luong
//        list.parallelStream().forEach(System.out::println);

        // Muc 2: Vector - dung giong het arraylist
        // Xu ly nhanh hon array list, nhung thua nhieu phat 10 o nho
        Vector<String> list2 = new Vector<>(); // 10 phan tu roi mo rong dan

        // Muc 3: LikedList
        // Moi ham deu giong vector. Quan ly theo con tro, moi phan tu cua no co 2 phan tu: gia tri phan tu,
        //con tro de tro toi phan tu tiep theo
        // Uu diem khong thua khong gian nho, nhuoc diem khong quan ly phan tu tap trung, luu o cac khong gian nho khac nhau -> cham
        LinkedList<String> list3 = new LinkedList<>();
        list3.add("A");

        //---------------------------------
        // Phan 2: Maps: HashMap, TreeMap, LinkedHashMap
        //Muc 1: HashMap: luu dang key - value
        Map<String, String> map = new HashMap<>();
        map.put("fullname", "Tran Van Diep");
        map.put("age", "1");
        map.put("address", "Nam Dinh");

        System.out.println(map.get("fullname"));

        HashMap<String, Student> studentList = new HashMap<>();
        Student std = new Student("R1", "Tran Van A");
        studentList.put(std.rollNo, std);

        std = new Student("R2", "Tran Van B");
        studentList.put(std.rollNo, std);

        Student std2 = studentList.get("R1");

        // Cach duyet phan tu trong HashMap
        // Cach 1
        Set<String> keys = map.keySet();
        keys.forEach((key) -> {
            System.out.println("key: " + key + " : " + map.get(key));
        });

        // cach 2
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // cach 3
        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        //methods
        if (map.containsKey("email")) {
            System.out.println("Email: " + map.get("email"));
        }

        // Muc 2: TreeMap, LinkedHasMap - giong hashmap
        Map<String, Object> tree = new TreeMap<>();
        Map<String, Object> linkedHasMap = new LinkedHashMap<>();

        //---------------------------------
        // Phan 3: Sets: HashSet, TreeSet, LinkedSet
//        1. Đặc điểm chính của Set
        //Không chứa phần tử trùng lặp: nếu bạn thêm một phần tử đã tồn tại, nó sẽ không được thêm.
        //Không có thứ tự cố định (trừ các lớp con đặc biệt như LinkedHashSet).
        //Có thể chứa một phần tử null (trừ TreeSet).
        //Các phương thức cơ bản:
        //add(E e) – thêm phần tử
        //remove(Object o) – xóa phần tử
        //contains(Object o) – kiểm tra tồn tại
        //size() – số lượng phần tử
        //isEmpty() – kiểm tra rỗng

//        2. Các lớp phổ biến triển khai Set
        //| Lớp               | Đặc điểm                                                                                   | Ví dụ                                                |
        //| ----------------- | ------------------------------------------------------------------------------------------ | ---------------------------------------------------- |
        //| **HashSet**       | Dùng **bảng băm (hash table)**, **không giữ thứ tự**                                       | `HashSet<String> set = new HashSet<>();`             |
        //| **LinkedHashSet** | Giữ **thứ tự chèn**, dựa trên **hash table + linked list**                                 | `LinkedHashSet<String> set = new LinkedHashSet<>();` |
        //| **TreeSet**       | Dựa trên **cây đỏ-đen (Red-Black Tree)**, **sắp xếp theo thứ tự tự nhiên hoặc Comparator** | `TreeSet<Integer> set = new TreeSet<>();`            |

//        3. Ví dụ sử dụng Set
        // 3.1 HashSet
        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple"); // Bị bỏ qua vì trùng

        System.out.println(fruits); // Không đảm bảo thứ tự

        // 3.2 LinkedHashSet
        Set<String> fruits2 = new LinkedHashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple");

        System.out.println(fruits2); // Giữ thứ tự: Apple, Banana

        // 3.2 LinkedHashSet
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);

        System.out.println(numbers); // Sắp xếp tự nhiên: 1, 3, 5

        // 4. Duyệt phần tử trong Set
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Hoặc dùng Iterator
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //---------------------------------
        // Phan 4: Stack (ngan xep - chong sach) and Queues
        //Stack: LIFO
        //Queues: (xep hang mua ve) FIFO
        //Methods: empty(), peek(), pop(), push (E item), int search (Object o)
        // push: dua phan tu vao
        // pop: lay phan tu ra

        //1. Queue (Hàng đợi)
//        Đặc điểm:
//        Tuân theo FIFO (First In, First Out) – phần tử vào trước sẽ ra trước.
//                Tương tự như xếp hàng tại siêu thị: ai đến trước sẽ được phục vụ trước.
//        Lớp triển khai:
//        Queue<E> là interface, các lớp triển khai phổ biến:
//            LinkedList → hỗ trợ Queue
//            PriorityQueue → tự sắp xếp theo priority
//            ArrayDeque → dùng làm queue hoặc deque

//        Các phương thức cơ bản:
//      | Phương thức                                 | Chức năng                                    |
//      | -------------- -----------  ----------      | -------------------------------------------- |
//      | `add(E e)` / `offer(E e)`                   | Thêm phần tử vào queue                       |
//      | `remove()` / `poll()`                       | Lấy và loại bỏ phần tử đầu tiên              |
//      | `element()` / `peek()`                      | Lấy phần tử đầu tiên nhưng **không loại bỏ** |
//      | `isEmpty()`                                 | Kiểm tra queue rỗng                          |
        Queue<String> queue = new LinkedList<>();
        queue.add("A");
        queue.add("B");
        queue.add("C");

        System.out.println(queue.peek()); // A
        System.out.println(queue.poll()); // A
        System.out.println(queue.poll()); // B

        PriorityQueue<String> queue1 = new PriorityQueue<>();
        queue1.offer("A1"); // giong push
        queue1.offer("A2");
        queue1.offer("A3");

        System.out.println(queue1.poll()); // giong pop
        System.out.println(queue1.poll()); // giong pop
        System.out.println(queue1.poll()); // giong pop

        //2. Stack (Ngăn xếp)
        //Đặc điểm:
        //Tuân theo LIFO (Last In, First Out) – phần tử vừa thêm vào sẽ được lấy ra trước.
        //Tương tự như chồng đĩa: bạn đặt đĩa mới lên trên cùng, lấy đĩa cũng từ trên cùng.
        //        Lớp triển khai:
        //Trong Java có lớp Stack<E> kế thừa từ Vector (cũ, ít được dùng hiện nay).
        //        Ngoài ra, bạn có thể dùng Deque<E> (khuyến nghị hơn) để làm stack.

        //Các phương thức cơ bản:
//        | Phương thức                  | Chức năng                                     |
//        | --------------               | --------------------------------------------- |
//        | `push(E item)`               | Thêm phần tử vào đỉnh stack                   |
//        | `pop()`                      | Lấy và loại bỏ phần tử trên cùng              |
//        | `peek()`                     | Lấy phần tử trên cùng nhưng **không loại bỏ** |
//        | `isEmpty()`                   | Kiểm tra stack rỗng                          |

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek()); // 3
        System.out.println(stack.pop());  // 3
        System.out.println(stack.pop());  // 2

    }
}
