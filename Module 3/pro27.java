import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pro27 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");
        names.add("David");

        Collections.sort(names, (a, b) -> a.compareTo(b));

        System.out.println("Sorted list:");
        names.forEach(System.out::println);
    }
}
