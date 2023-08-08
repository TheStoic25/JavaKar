package com.ev.collections;

import com.ev.domain.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class EmployeeSet {
    public static void main(String[] args) {
        Set<Employee> employeeSet = new TreeSet<>(Comparator.comparing(Employee::getFirstName));
        try(BufferedReader bufferedReader =
                    new BufferedReader(new FileReader("C:\\Users\\kb257\\Documents\\ev_project_business\\EVDataSource\\src\\main\\resources\\people.txt"))){
            while (bufferedReader.ready()){
                Employee employee = Employee.createEmployee(bufferedReader.readLine());
                employeeSet.add(employee);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Employee employee : employeeSet) {
            System.out.println(employee);
        }
    }
}
