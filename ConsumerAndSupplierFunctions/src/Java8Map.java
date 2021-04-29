import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//The map() function is a method in the Stream class that represents a functional programming concept.
// In simple words, the map() is used to transform one object into other by applying a function.
public class Java8Map {

    public static void main(String[] args) {

        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");

        // Before Java 8
        String result = "";
        for (Map.Entry<Integer, String> entry : HOSTING.entrySet()) {
            if ("aws.amazon.com".equals(entry.getValue())) {
                result = entry.getValue();
            }
        }

        System.out.println("Before Java 8 : " + result);


        //Map -> Stream -> Filter -> String
        result = HOSTING.entrySet().stream().filter(map -> "aws.amazon.com".equals(map.getValue())).map(map -> map.getValue()).collect(Collectors.joining());

        System.out.println("With Java 8 : " + result);
        
        List<String> strings = Arrays.asList("ab","ba","ca","dd");

        String stringResult = strings.stream().filter(character -> character.contains("a")).map(s -> s.replace("a", "A")).collect(Collectors.joining(","));

        System.out.println( stringResult);


        //Map -> Stream -> Filter -> Map
        Map<Integer, String> collect = HOSTING.entrySet().stream().filter(map -> map.getKey()==2).collect(Collectors.toMap(p -> p.getKey(),p -> p.getValue()));

        System.out.println(collect);


        List<String> stringNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");

        List<Integer> integerNumbers = stringNumbers.stream().map(Integer::valueOf).filter(integer -> integer %2 ==0).collect(Collectors.toList());
        System.out.println(integerNumbers);


    }
}
