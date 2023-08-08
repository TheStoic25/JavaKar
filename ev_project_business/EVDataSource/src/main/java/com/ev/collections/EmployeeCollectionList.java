package com.ev.collections;

import com.ev.domain.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class EmployeeCollectionList {
    public static void main(String[] args) {
        /*
          try with resource
          no need to close the resource as try resource automatically does it
         */
        List<Employee> employees = new LinkedList<>();
        try(BufferedReader bufferedReader =
                    new BufferedReader(new FileReader("C:\\Users\\kb257\\Documents\\ev_project_business\\EVDataSource\\src\\main\\resources\\people.txt"))){
            while (bufferedReader.ready()){
                Employee employee = Employee.createEmployee(bufferedReader.readLine());
                employees.add(employee);
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        int totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        System.out.printf("$%d.00 \n",totalSalary);

        Employee employee = employees.get(0);
        boolean testFlagEmployee = employees.contains(employee);
        System.out.println(testFlagEmployee);

        /*
          Create a new record and check for contains method
         */
        String newDataForEmployeeCreation = "Leo, dicaprio, 1/1/1990, Programmer, {hourlyPay = 100, totalHours = 110}";
        Employee newEmployee = Employee.createEmployee(newDataForEmployeeCreation);
        System.out.println(employees.contains(newEmployee));

        /*
         * Remove undesired names
         * */
        List<String> undesiredNames = List.of("Tim");
        for(Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();){
            String toRemoveEmployee = iterator.next().getFirstName();
            if(undesiredNames.contains(toRemoveEmployee)){
                iterator.remove();
            }
        }

//        for (Employee employee1 : employees) {
//            undesiredNames.forEach(a->{
//                if(employee1.getFirstName().equalsIgnoreCase(a)){
//                    employees.remove(employee1);
//                }
//            });
//        }

        employees.sort(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary));

        for (Employee employee1 : employees) {
            System.out.println(employee1);
        }
    }
}
