package JUC高级.UnSafeThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","v");
        list.forEach(System.out::println);

        //上面高级一点的写法其实是下面的变种
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("v");
        for (String element: list2) {
            System.out.println(element);
        }
        System.out.println(UUID.randomUUID().toString());
    }
}
