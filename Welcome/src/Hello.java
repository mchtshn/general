public class Hello {

    public static void main(String[] args) {
        Hello hello = new Hello();

        Person person = new Person();
        person.setName("Mücahit");
        hello.mpdifyPerson(person);
        System.out.println(person.getName());


        Person p1 = new Person("Metin");
        Person p2 = new Person("Yusuf");

        System.out.println("----------main----------");
        System.out.println(p1);
        System.out.println(p2);

        hello.swap(p1, p2);

        System.out.println("----------main2----------");
        System.out.println(p1);
        System.out.println(p2);


    }

    public void mpdifyPerson(Person person) {
        person.setName("Fatih");
    }
    public  void swap(Person p1Param, Person p2Param) {

        Person temp = p1Param;
        p1Param = p2Param;
        p2Param = temp;

        System.out.println("----------swap----------");
        System.out.println(p1Param);
        System.out.println(p2Param);
    }


}

class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
