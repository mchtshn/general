package com.mucahit.rest.webservices.restfulwebservices.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestEmployee {

    public static void main(String[] args) {

        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
        Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
        Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
        Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
        Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
        Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
        Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
        Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
        Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        testPredicates(employees);
        testStream(employees);

    }

    private static void testPredicates(List<Employee> employees) {

        System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAdultMale()));
        System.out.println("*********************************");
        System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAdultFemale()));
        System.out.println("*********************************");
        System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isMoreThan(35)));
        System.out.println("*********************************");
    }

    private static void testStream(List<Employee> employees) {
        employees.stream().filter(employee -> employee.getFirstName().startsWith("N")).forEach(System.out::println);
        System.out.println("*********************************");
        System.out.println(employees.stream().anyMatch(employee -> employee.getAge() > 15));
        System.out.println("*********************************");
        employees.stream().sorted(Comparator.comparing(Employee::getAge)).forEach(System.out::println);
        System.out.println("*********************************");
        employees.stream().filter(employee -> employee.getAge()%2==0).forEach(System.out::println);
        System.out.println("*********************************");
        employees.stream().sorted(Comparator.comparing(Employee::getFirstName)).forEach(employee -> System.out.println(employee.getFirstName()));
        System.out.println("*********************************");
        employees.stream().sorted(Comparator.comparing(Employee::getFirstName)).filter(EmployeePredicates.isOdd()).forEach(employee -> System.out.println(employee.getAge()));
        System.out.println("*********************************");

    }
}
