import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Java8Date {

    public static void main(String[] args) {


        String date = "2017-03-08T12:30:54";

        //default format iso format ıdır. Bundan dolayı format vermeden parse edillebilir.
        //parse -> from string to localdatetime object
        LocalDateTime localDateTime = LocalDateTime.parse(date);
        System.out.println(localDateTime);

        /*
        Prior to Java 8, you might be aware that we use SimpleDateFormat and DateFormat class to represent a format, which has lots of problem
         e.g. they were heavy, mutable, and not thread-safe, which means you cannot share them and every time you need to convert String to Date,
         you have to create a new DateFormat object. Though encapsulating SimpleDateFormat into a thread-local variable does offer some respite, it wasn't enough.

         JDK 8 has addressed this problem in the new DateTimeFormatter class, which can be used to define the date and time format
          e.g. "yyyy-MM-dd HH: mm", the syntax to specify the format is same as what we use earlier with SimpleDateFormat class,
          but this class is both thread-safe and immutable which means you can share its instance between threads.
          Ideally, you can store the reference of DateTimeFormatter into a static variable to make it global.
         */


        String date1 = "2017-03-08T12:30:54";
        LocalDateTime localdatetime = LocalDateTime.parse(date);
        System.out.println("origional date as string: " + date);
        System.out.println("generated LocalDateTime: " + localdatetime);

        String date2 = "2017-03-08 12:30:54";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date2, format);
        System.out.println("origional date as string: " + date);
        System.out.println("generated LocalDateTime: " + localdatetime);


    }
}
