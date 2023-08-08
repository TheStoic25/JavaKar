package com.ev.streams;

import com.ev.domain.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;

public class EmployeeFilter {
    public static void main(String[] args) throws IOException {
        Predicate<Employee> employeePredicate = (str)->str.getSalary() > 10000;

        Files.readAllLines(Path.of("C:\\Users\\kb257\\Documents\\ev_project_business\\EVDataSource\\src\\main\\resources\\people.txt"))
                .stream()
                .map(employeeStr->Employee.createEmployee(employeeStr))
                .filter(employeePredicate)
                .forEach(System.out::println);
    }
}
