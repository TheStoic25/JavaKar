package com.ev.streams;

import com.ev.domain.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

public class StreamSorting {
    public static void main(String[] args) throws IOException {
        Files.readAllLines(Path.of("C:\\Users\\kb257\\Documents\\ev_project_business\\EVDataSource\\src\\main\\resources\\people.txt"))
                .stream()
                .map(employeeStr-> Employee.createEmployee(employeeStr))
                .sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary))
                .forEach(System.out::println);
    }
}
