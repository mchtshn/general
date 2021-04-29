package com.mucahit;

import javax.crypto.spec.PSource;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        optionalEmpty();
        System.out.println("*******************");
        optionalOf();
        System.out.println("*******************");
        optionalOfNullable();
        System.out.println("*******************");
        ifPresent();
        System.out.println("*******************");
        orElse();
        System.out.println("*******************");
        orElseGet();
        System.out.println("*******************");
        orElseThrow();
        System.out.println("*******************");
        map();
        System.out.println("*******************");
        filter();

    }


    //boş bir Optional objesi olusturur.
    public static void optionalEmpty() {

        Optional<String> stringOptional = Optional.empty();
        System.out.println(stringOptional.isPresent());

    }

    //eğer null ise nullpointerexception fırlatır.
    public static void optionalOf() {

        String name = "asdas";
        Optional<String> optionalName = Optional.of(name);
        System.out.println(optionalName.get());


        //throws null pointer exception
        /*String name2 = null;
        Optional<String> optionalName2 = Optional.of(name2);
        System.out.println(optionalName2.get());*/

        System.out.println(optionalName.isPresent());


        Optional<String> opt = Optional.of("null değilim ben");

        //eğer opt içinde değer varsa console a yazdıracak, yoksa geçecek.
        opt.ifPresent(s -> {
            System.out.println(s.toUpperCase());
        });

        opt.ifPresent(System.out::println);

    }

    //null olabilir. hata fırlatmaz
    public static void optionalOfNullable() {

        String name = "asdas";
        Optional<String> optionalName = Optional.of(name);
        System.out.println(optionalName.get());

        System.out.println(Optional.ofNullable(null));


    }

    //varsa yap,yoksa yapma
    public static void ifPresent() {
        Optional<String> name = Optional.ofNullable("asdas");
        name.ifPresent(System.out::println);
        Optional.of(Arrays.asList("a,b,c,d".split(","))).map(strings -> { strings.forEach(String::toUpperCase);
            return strings;
        }).ifPresent(strings -> {
            strings.forEach(s -> {
                String s1 = s + s.toLowerCase();
                System.out.println(s1);
            });
        });
    }


    //Eğer değer varsa onu alır,yoksa orElse içindeki olay gerçekleşir
    public static void orElse() {
        Optional<String> name = Optional.ofNullable("asdas");


        System.out.println(name.orElse("name içinde bir değer yok"));

        System.out.println(Optional.ofNullable(null).orElse("null olduğu için ben çalıştım"));
        System.out.println(Optional.ofNullable("Boş olmadığım için ben çalıştım").orElse("null olduğu için ben çalıştım"));
    }

    //Eğer değer varsa onu alır,yoksa üretir.
    public static void orElseGet() {
        List<String> names = Arrays.asList("ali", "veli", "49", "50");

        Optional<List<String>> namesOptional = Optional.ofNullable(names);


        System.out.println(namesOptional.orElseGet(ArrayList::new));

        List<String> namesNull = null;

        Optional<List<String>> namesOptionalNull = Optional.ofNullable(namesNull);

        namesNull = namesOptionalNull.orElseGet(() -> new ArrayList<>()); //1
        namesNull = namesOptionalNull.orElseGet(ArrayList::new); //2
    }

    //Eğer değer varsa onu alır,yoksa hata fırlatır.
    public static void orElseThrow() {
        List<String> names = null;

        Optional<List<String>> namesOptional = Optional.ofNullable(names);
        //System.out.println(namesOptional.orElseThrow(() -> new RuntimeException("orElseThrow a girdim")));

    }

    //dönüştürme
    public static void map() {
        Integer number = 2;

        Optional<Integer> optionalInteger = Optional.ofNullable(number);

        optionalInteger.map(num -> Math.pow(num, 2)).ifPresent(System.out::println);


    }

    //filtreler
    public static void filter() {
        Optional<List<String>> opt = Optional.ofNullable(Arrays.asList("ali","veli","kemal","12"));

        opt.filter(m -> m.get(0).contains("i"))
                .ifPresent(System.out::println);

        Optional<Integer> optionalInteger = Optional.ofNullable(12);

        optionalInteger.filter(num -> num%2==0).ifPresent(integer -> System.out.println(integer));

    }
}
