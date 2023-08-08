package com.ev.streams;

import com.ev.domain.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;

public class StreamsIntermediate {
    public static void main(String[] args) throws IOException {
        Function<String, Employee> employeeFunction = (str)->Employee.createEmployee(str);

        int result = Files.readAllLines(Path.of("C:\\Users\\kb257\\Documents\\ev_project_business\\EVDataSource\\src\\main\\resources\\people.txt"))
                .stream()
                .map(employeeFunction)
                .map(Employee::getSalary)
                .mapToInt(a->a)
                .sum();
        System.out.printf("$%s.00",result);
    }
}
