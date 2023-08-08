package com.ev.streams;

import com.ev.domain.Employee;
import com.ev.service.IEmployee;
import com.github.javafaker.Faker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StreamsRecordInfoCreateData {
    record SalesPerson(String name, String country, Long salary, String phoneNumber){
        @Override
        public String toString() {
            return String.format("%s,%s,%s,%s ",name, country, salary, phoneNumber);
        }
    }
    public static void main(String[] args) throws IOException {
        Faker faker = new Faker();
        List<SalesPerson> salesPersonList = new ArrayList<>();
        for(int i = 0 ; i < 500000 ; i++){
            SalesPerson salesPerson = new SalesPerson(faker.name().fullName(),faker.address().country(),
                    (long) faker.number().numberBetween(10000,100000),faker.phoneNumber().cellPhone());
            salesPersonList.add(salesPerson);
        }

        FileWriter fileWriter = new FileWriter("C:\\Users\\kb257\\Documents\\ev_project_business\\EVDataSource\\src\\main\\resources\\sales.txt");
        salesPersonList.forEach(a->{
            try {
                fileWriter.append(a.toString());
                fileWriter.append("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        fileWriter.close();
    }
}
