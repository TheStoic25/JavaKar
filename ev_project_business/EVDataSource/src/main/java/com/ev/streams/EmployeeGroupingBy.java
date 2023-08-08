package com.ev.streams;

import com.ev.domain.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class EmployeeGroupingBy {
    public static void main(String[] args) throws IOException {
        Map<LocalDate, Long> result = Files.readAllLines(Path.of("C:\\Users\\kb257\\Documents\\ev_project_business\\EVDataSource\\src\\main\\resources\\people.txt"))
                .stream()
                .map(str-> Employee.createEmployee(str))
                .collect(Collectors.groupingBy(Employee::getDob, TreeMap::new,Collectors.counting()));

        for(Map.Entry<LocalDate, Long> entries : result.entrySet()){
            System.out.println(entries);
        }

    }
}
