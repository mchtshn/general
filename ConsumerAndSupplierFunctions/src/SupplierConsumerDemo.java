import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

// a functional interface, Supplier and Consumer.In simple words, a supplier is a method that returns a value.
// A supplier is any method which takes no arguments and returns a value. Its job is to supply an instance of an expected class.
// For example, every reference to a getter method is a supplier.The Supplier interface also have a method T get() that returns a value of of type T.
// Supplier functional interface doesn’t take any input but returns an output.
// Therefore whenever you need a function that returns something, for example, an Integer, but takes no output, this is an instance of Supplier.
// For example, every reference to a setter method is consumer:
// Consumer functional interface in Java 8 under package java.util.function represents the structure and takes input but does not return any output.
// This functional interface can be used as the assignment target for a lambda expression or method reference.
public class SupplierConsumerDemo {

    public static void main(String[] args) {
        System.out.println("\n\nE.g. #1 - Java8 Consumer Example\n");

        Consumer<String> consumer = SupplierConsumerDemo::printNamesForConsumers;
        consumer.accept("C++");
        consumer.accept("Java");
        consumer.accept("Python");
        consumer.accept("Ruby On Rails");

        System.out.println("\n\nE.g. #2 - Java8 Supplier Example\n");

        List<String> greets = Arrays.asList("Hi", "Hey", "Hello");

        Consumer<String> consumer2 = s -> System.out.println(s);

        greets.forEach(consumer2);

        System.out.println("\n\nE.g. #3 - Java8 Supplier Example\n");

        List<String> names = new ArrayList<>();
        names.add("Harry");
        names.add("Daniel");
        names.add("Lucifer");
        names.add("April O' Neil");

        names.stream().forEach((item)-> printNamesForSuppliers(()-> item));

        System.out.println("\n\nE.g.  #4 - Java8 Supplier Example\n");
        supply(() -> "Hi");
        supply(() -> "Hey");
        supply(() -> "Hello");
    }

    private static void printNamesForConsumers(String name) {
        System.out.println(name);
    }

    private static void printNamesForSuppliers(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }

    public static void supply(Supplier<?> supplier) {
        System.out.println(supplier.get());
    }
}
