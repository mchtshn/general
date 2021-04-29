package com.mucahit.rest.webservices.restfulwebservices.java8;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicates {

    public static Predicate<Employee> isAdultMale() {
        return employee -> employee.getAge() > 18 && employee.getGender().equalsIgnoreCase("M");
    }


    public static Predicate<Employee> isAdultFemale() {
        return employee -> employee.getAge() > 18 && employee.getGender().equalsIgnoreCase("F");
    }

    public static Predicate<Employee> isMoreThan(Integer age) {
        return employee -> employee.getAge() > age;
    }

    public static Predicate<Employee> isOdd() {
        return employee -> employee.getAge() %2==1;
    }


    public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
        return employees.stream().filter(predicate).collect(Collectors.toList());
    }
}
