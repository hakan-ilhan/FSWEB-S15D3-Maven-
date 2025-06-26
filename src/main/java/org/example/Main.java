package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Hakan", "İlhan"));
        employees.add(new Employee(2, "Arda", "Y"));
        employees.add(new Employee(3, "Irmak", "X"));
        employees.add(new Employee(1, "Hakan", "İlhan"));
        employees.add(new Employee(4, "Oğuz", "B"));
        employees.add(new Employee(4, "Oğuz", "B"));


    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> employeesSet = new HashSet<>();
        List<Employee> duplicates = new ArrayList<>();

        for (Employee employee : list) {
            if (!employeesSet.add(employee)) {
                duplicates.add(employee);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> uniques = new HashMap<>();

        for (Employee employee : list) {
            if (employee == null) continue;
            if (uniques.containsKey(employee.getId())) {
                continue;
            } else {
                uniques.put(employee.getId(), employee);
            }
        }

        return uniques;

    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        List<Employee> duplicates = findDuplicates(list);
        Map<Integer, Employee> uniques = findUniques(list);
        List<Employee> onlyUnique = new LinkedList<>(uniques.values());
        onlyUnique.removeAll(duplicates);
        return onlyUnique;

    }
}