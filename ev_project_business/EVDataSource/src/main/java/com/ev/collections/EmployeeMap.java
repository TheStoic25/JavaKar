package com.ev.collections;

import com.ev.domain.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeMap {
    public static void main(String[] args) {
        Map<String,Long> salariedMap = new HashMap<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\kb257\\Documents\\ev_project_business\\EVDataSource\\src\\main\\resources\\people.txt"))){
            while (bufferedReader.ready()){
                Employee employee = Employee.createEmployee(bufferedReader.readLine());
                if(employee != null){
                    salariedMap.put(employee.getLastName(), (long) employee.getSalary());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Long salary = salariedMap.getOrDefault("max",0L);
        for(Map.Entry<String,Long> entry : salariedMap.entrySet()){
            entry.getKey();
        }
    }
}
