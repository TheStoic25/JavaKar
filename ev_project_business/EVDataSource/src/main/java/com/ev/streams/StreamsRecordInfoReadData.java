package com.ev.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StreamsRecordInfoReadData {
    record SalesPerson(String name, String country, Long salary, String telephone){
        @Override
        public String toString() {
            return String.format("%s,%s,%s,%s",name,country,salary,telephone);
        }
    }
    public static void main(String[] args) throws IOException {
        Long result = Files.readAllLines(Path.of("C:\\Users\\kb257\\Documents\\ev_project_business\\EVDataSource\\src\\main\\resources\\sales.txt"))
                .stream()
                .limit(10)
                .map(a->a.split(","))
                .map(salesRecord ->
                        new SalesPerson(salesRecord[0],salesRecord[1],Long.valueOf(salesRecord[2]),salesRecord[3] ))
                .map(salesRecord -> salesRecord.salary())
                .mapToLong(a->a)
                .sum();
        System.out.printf("$%s.00",result);
    }
}
