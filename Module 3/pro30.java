public class pro30 {
    public static void checkObjectType(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("Integer value: " + i);
            case String s -> System.out.println("String value: " + s);
            case Double d -> System.out.println("Double value: " + d);
            case null -> System.out.println("Object is null");
            default -> System.out.println("Unknown type: " + obj.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        checkObjectType(123);
        checkObjectType("Hello");
        checkObjectType(45.67);
        checkObjectType(true);
        checkObjectType(null);
    }
}
